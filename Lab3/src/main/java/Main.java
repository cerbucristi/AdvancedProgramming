import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Node> nodes = new LinkedList<>();
        Node node1 = new Company("company1");
        Node node2 = new Company("company2");
        Node node3 = new Person("Costel");
        Node node4 = new Person("Viorel");

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        List<Node> nodesSort = new LinkedList<>();

        Node node5 = new Person("Ana");

        nodesSort.add(node3);
        nodesSort.add(node4);
        nodesSort.add(node5);

        System.out.println(nodes);
        System.out.println(nodesSort.stream().sorted().collect(Collectors.toList()));
    }
}
