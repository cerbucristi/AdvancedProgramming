package utils.command;

import exceptions.CommandExecutionException;
import exceptions.InvalidCatalogException;
import filemanagement.Catalog;

public class ListCommand implements Command{

    private Catalog catalog;

    private StringBuilder stringBuilder;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Catalog ").append(catalog.getCatalogName()).append(" contains documents: ");
            if (catalog == null) {
                throw new InvalidCatalogException("Catalog was not instantiated!");
            }
            catalog.getDocumentList().forEach(document -> stringBuilder.append("\n").append(document.toString()).append("\n"));
        } catch (InvalidCatalogException e) {
            throw new CommandExecutionException(e);
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getResult () {
        return stringBuilder.toString();
    }
}
