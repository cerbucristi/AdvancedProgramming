package utils.command.nativeserizalization;

import utils.command.Command;
import exceptions.CommandExecutionException;
import filemanagement.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCatalogCommand implements Command {

    private String path;
    private Catalog catalog;

    public SaveCatalogCommand(String path, Catalog catalog) {
        this.path = path;
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            var oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(catalog);
        } catch (IOException e) {
            throw new CommandExecutionException(e);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
