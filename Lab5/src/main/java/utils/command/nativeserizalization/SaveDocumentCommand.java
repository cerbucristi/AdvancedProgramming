package utils.command.nativeserizalization;

import exceptions.CommandExecutionException;
import filemanagement.Document;
import utils.command.Command;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//This is a helper class

public class SaveDocumentCommand implements Command {

    private Document document;

    public SaveDocumentCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() throws CommandExecutionException {

        try {
            var oos = new ObjectOutputStream(new FileOutputStream(document.getLocation() + document.getTitle()));
            oos.writeObject(document);
        } catch (IOException e) {
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
