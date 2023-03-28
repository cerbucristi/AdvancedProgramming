package utils.command.jsonserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.command.Command;
import exceptions.CommandExecutionException;
import filemanagement.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {

    private String path;

    private Catalog catalog;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws CommandExecutionException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class);
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
