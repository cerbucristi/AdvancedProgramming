import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Node {

    private String strPersonName;
    private LocalDate birthDate;

    private Map<Node, RelationEnum> relationMap = new HashMap<>();

    public Person(String strPersonName, LocalDate birthDate) {
        this.strPersonName = strPersonName;
        this.birthDate = birthDate;
    }

    @Override
    public void addRelationship(Node node, RelationEnum relation) {
        relationMap.put(node, relation);
    }

    public abstract String getOccupation();

    @Override
    public String getName() {
        return this.strPersonName;
    }

    @Override
    public int getNodeImportance(){
        return relationMap.size();
    }
    @Override
    public String toString() {
        return "Person{" +
                "strPersonName='" + strPersonName + '\'' +
                '}';
    }

    public String getStrPersonName() {
        return strPersonName;
    }

    public void setStrPersonName(String strPersonName) {
        this.strPersonName = strPersonName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Map<Node, RelationEnum> getRelationMap() {
        return relationMap;
    }

    public void setRelationMap(Map<Node, RelationEnum> relationMap) {
        this.relationMap = relationMap;
    }
}
