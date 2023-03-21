import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.InvalidCatalogException;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    //JSON serialization
    public static void save (Catalog catalog, String path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    //JSON serialization
    public static Catalog load (String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(path),
                    Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }

    public static void view(Document document) {
        System.out.println(document.toString());
    }
}
