import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Network {

    List<Node> nodes;

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Network() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }


    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes.stream().sorted().collect(Collectors.toList()) +
                '}';
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
