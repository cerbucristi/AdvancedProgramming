import java.util.Map;

public interface Node extends  Comparable<Node> {

    String getName();

    int getNodeImportance();

    void addRelationship(Node node, RelationEnum relation);

    @Override
    default int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }
}
