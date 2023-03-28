package utils.command;

import exceptions.CommandExecutionException;
import exceptions.InvalidDocumentException;
import filemanagement.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private Document document;

    public ViewCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() throws CommandExecutionException {

        try {
            if (document == null) {
                throw new InvalidDocumentException("Document was not instantiated!");
            }
            File file = new File(document.getLocation());
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (IOException | InvalidDocumentException e) {
            throw new CommandExecutionException(e);
        }
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
