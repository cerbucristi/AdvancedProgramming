package utils.command.nativeserizalization;

import utils.command.Command;
import exceptions.CommandExecutionException;
import exceptions.InvalidCatalogException;
import filemanagement.Catalog;
import filemanagement.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AddCommand implements Command {
    private String filePath;
    private Catalog catalog;

    public AddCommand(String filePath, Catalog catalog) {
        this.filePath = filePath;
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            var ois = new ObjectInputStream(new FileInputStream(filePath));
            Document document = (Document) ois.readObject();
            if (catalog == null) {
                throw new InvalidCatalogException("Object catalog was not instantiated");
            }
            catalog.add(document);
            System.out.printf("Document %s added to the catalog.%n", document.getTitle());
        } catch (IOException | ClassNotFoundException | InvalidCatalogException e) {
            throw new CommandExecutionException(e);
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
