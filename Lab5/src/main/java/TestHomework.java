import exceptions.CommandExecutionException;
import filemanagement.Catalog;
import filemanagement.Document;
import utils.command.CreateReportCommand;
import utils.command.ListCommand;
import utils.command.ViewCommand;
import utils.command.nativeserizalization.AddCommand;
import utils.command.nativeserizalization.SaveDocumentCommand;


public class TestHomework {

    public static void main(String[] args) {

        Catalog catalog = new Catalog("mainCatalog");
        Document document = new Document("doc1", "test1Doc", "src/main/resources/");
        SaveDocumentCommand saveDocumentCommand = new SaveDocumentCommand(document);
        AddCommand addCommand = new AddCommand(document.getLocation() + document.getTitle(), catalog);
        ListCommand listCommand = new ListCommand(catalog);
        ViewCommand viewCommand = new ViewCommand(document);
        CreateReportCommand createReportCommand = new CreateReportCommand(catalog);
        try {
            saveDocumentCommand.execute();
            addCommand.execute();
            listCommand.execute();
            System.out.println(listCommand.getResult());
            viewCommand.execute();
            createReportCommand.execute();
        } catch (CommandExecutionException e) {
            System.out.println("Error when saving document!" + e);
        }
    }
}
