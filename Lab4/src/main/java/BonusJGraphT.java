import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;
import org.jgrapht.Graph;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.*;

public class BonusJGraphT {
    public static void main(String[] args) {

        //generate random projects and students
        //we can model the problem as a bipartite graph where the vertices are the students and the projects,
        // and the edges represent the preferences of each student for each project.
        // we can use the Hopcroft-Karp algorithm to find the maximum cardinality matching on this graph.

        Faker faker = new Faker();

        Set<Node> fakerProjects = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            fakerProjects.add(new Project(faker.app().name()));
        }


        Set<Node> fakerStudents = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            fakerStudents.add(new Student(faker.name().firstName()));
        }

        //JGraphT
        Graph<Node, DefaultEdge> graph= new DefaultUndirectedGraph<>(DefaultEdge.class);
        fakerStudents.forEach(graph::addVertex);
        fakerProjects.forEach(graph::addVertex);

        Random random = new Random();

        //setting graph edges
        fakerStudents.forEach(student -> {
            for(int i = 0; i < random.nextInt(fakerProjects.size() - 1) + 1; i++) {
                graph.addEdge(student, new ArrayList<>(fakerProjects).get(random.nextInt(fakerProjects.size() - 1) + 1));
            }
        });

        // Use the Hopcroft-Karp algorithm to find the maximum cardinality matching
        HopcroftKarpMaximumCardinalityBipartiteMatching<Node, DefaultEdge> hopcroftKarp =
                new HopcroftKarpMaximumCardinalityBipartiteMatching<>(graph, fakerStudents, fakerProjects);

        Set<DefaultEdge> matching = hopcroftKarp.getMatching().getEdges();

        // Print the maximum cardinality matching
        System.out.println("Maximum cardinality matching:");
        List<Pair<Node, Node>> myMatches = new ArrayList<>();
        for (DefaultEdge path : matching) {
            myMatches.add(Pair.of(graph.getEdgeSource(path), graph.getEdgeTarget(path)));
        }

        for (Pair<Node, Node> match : myMatches) {
            System.out.println(match.getLeft().getName() + "->" + match.getRight().getName() + "\n");
        }

    }
}
