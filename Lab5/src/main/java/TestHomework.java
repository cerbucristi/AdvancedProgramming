import exceptions.CommandExecutionException;
import filemanagement.Catalog;
import filemanagement.Document;
import org.apache.tika.metadata.Metadata;
import utils.MetadataExtractor;
import utils.command.CreateReportCommand;
import utils.command.ListCommand;
import utils.command.ViewCommand;
import utils.command.nativeserizalization.AddCommand;
import utils.command.nativeserizalization.SaveDocumentCommand;

import java.io.File;


public class TestHomework {

    public static void main(String[] args) {

        Catalog catalog = new Catalog("mainCatalog");
        Document document = new Document("doc", "testDoc", "");
        Document document1 = new Document("doc1", "test1Doc", "");
        SaveDocumentCommand saveDocumentCommand = new SaveDocumentCommand(document);
        AddCommand addCommand = new AddCommand(document.getLocation() + document.getTitle(), catalog);
        ListCommand listCommand = new ListCommand(catalog);
        ViewCommand viewCommand = new ViewCommand(document);
        CreateReportCommand createReportCommand = new CreateReportCommand(catalog);
        try {
            saveDocumentCommand.execute();
            saveDocumentCommand.setDocument(document1);
            saveDocumentCommand.execute();
            addCommand.execute();
            addCommand = new AddCommand(document1.getLocation() + document1.getTitle(), catalog);
            addCommand.execute();
            listCommand.execute();
            System.out.println(listCommand.getResult());
            viewCommand.execute();
            createReportCommand.execute();
        } catch (CommandExecutionException e) {
            System.out.println("Error when saving document!" + e);
        }

        Metadata metadata = null;
        try {
            metadata = MetadataExtractor.extractMetadata(new File("report.html"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (String name : metadata.names()) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}
