
import javax.print.Doc;
import java.util.LinkedList;
import java.util.List;

public class Catalog {

    private String catalogName;
    private List<Document> documentList;


    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        documentList = new LinkedList<>();
    }

    public void add (Document document) {
        documentList.add(document);
    }

    public Document findById(String id) {
        return documentList.stream().filter(document -> document.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogName='" + catalogName + '\'' +
                ", documentList=" + documentList +
                '}';
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
