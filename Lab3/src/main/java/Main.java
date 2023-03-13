import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Node> nodes = new LinkedList<>();
        Node node1 = new Company("Amazon");
        Node node2 = new Company("Continental");
        List<String> programmingLanguages = new LinkedList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        Node node3 = new Programmer("Costel", LocalDate.parse("1988-05-22", formatter), programmingLanguages, true);

        List<String> designSoftware = new LinkedList<>();
        designSoftware.add("Photoshop");
        designSoftware.add("Adobe");
        Node node4 = new Designer("Viorel",  LocalDate.parse("2000-05-22", formatter), designSoftware, 5);

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        node1.addRelationship(node3, RelationEnum.EMPLOYEE);
        node1.addRelationship(node4, RelationEnum.EX_EMPLOYEE);


        programmingLanguages.add("Haskell");
        Node node5 = new Programmer("Ana", LocalDate.parse("1998-04-12", formatter), programmingLanguages, false);

        node2.addRelationship(node5, RelationEnum.EMPLOYEE);
        node2.addRelationship(node4, RelationEnum.EMPLOYEE);
        node2.addRelationship(node3, RelationEnum.EX_EMPLOYEE);

        node3.addRelationship(node1, RelationEnum.EMPLOYER);

        node4.addRelationship(node2, RelationEnum.EMPLOYER);
        node4.addRelationship(node1, RelationEnum.EX_EMPLOYER);
        node4.addRelationship(node3, RelationEnum.BOSS);
        node4.addRelationship(node4, RelationEnum.FRIEND);
        node4.addRelationship(node5, RelationEnum.FRIEND);

        node5.addRelationship(node2, RelationEnum.EMPLOYER);
        node5.addRelationship(node3, RelationEnum.FRIEND);
        node5.addRelationship(node4, RelationEnum.SUBORDINATED);
        node5.addRelationship(node1, RelationEnum.EX_EMPLOYER);

        List<Node> nodesSort = new LinkedList<>();
        nodesSort.add(node1);
        nodesSort.add(node3);
        nodesSort.add(node4);
        nodesSort.add(node5);

        Network network = new Network();
        network.addNode(node1);
        network.addNode(node2);
        network.addNode(node3);
        network.addNode(node4);
        network.addNode(node5);

        //nodurile ordonate dupa importanta
        System.out.println(network);

        System.out.println(network.getNodes().stream().sorted().collect(Collectors.toList()));
    }
}
