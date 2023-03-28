package utils.command.nativeserizalization;

import utils.command.Command;
import exceptions.CommandExecutionException;
import filemanagement.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand implements Command {

    private String path;

    private Catalog catalog;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            var ois = new ObjectInputStream(new FileInputStream(path));
            catalog = (filemanagement.Catalog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
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
