import exceptions.InvalidCatalogException;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        } catch (IOException e) {
            System.out.println("Error when saving..");
        } catch (InvalidCatalogException e) {
            System.out.println("Error when loading..");
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("MyDocuments");
        var book = new Document("article1", "Article about animals" , "location1" );
        var article = new Document("book1", "Book of stories" , "location2" );
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "src/main/resources/catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("src/main/resources/catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }
}
