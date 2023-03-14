import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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


    public void sortNetworkByImportance(){
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.getNodeImportance(), o2.getNodeImportance());
            }
        });
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
