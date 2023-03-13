import java.util.HashMap;
import java.util.Map;

public class Company implements Node {

    private String strCompanyName;

    private Map<Node, RelationEnum> relationMap = new HashMap<>();


    public Company(String strCompanyName) {
        this.strCompanyName = strCompanyName;
    }
    @Override
    public void addRelationship(Node node, RelationEnum relation) {
        relationMap.put(node, relation);
    }

    @Override
    public String getName() {
        return this.strCompanyName;
    }

    @Override
    public int getNodeImportance() {
        return relationMap.size();
    }

    @Override
    public String toString() {
        return "Company{" +
                "strCompanyName='" + strCompanyName + '\'' +
                '}';
    }

    public String getStrCompanyName() {
        return strCompanyName;
    }

    public void setStrCompanyName(String strCompanyName) {
        this.strCompanyName = strCompanyName;
    }

    public Map<Node, RelationEnum> getRelationMap() {
        return relationMap;
    }

    public void setRelationMap(Map<Node, RelationEnum> relationMap) {
        this.relationMap = relationMap;
    }
}
