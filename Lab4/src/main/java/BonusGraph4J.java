import com.github.javafaker.Faker;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.graph4j.util.Matching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BonusGraph4J {
    //generate random projects and students
    //we can model the problem as a bipartite graph where the vertices are the students and the projects,
    // and the edges represent the preferences of each student for each project.
    // we can use the Hopcroft-Karp algorithm to find the maximum cardinality matching on this graph.

    public static void main(String[] args) {

        Faker faker = new Faker();

        Set<String> fakerProjects = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            fakerProjects.add(faker.app().name());
        }


        Set<String> fakerStudents = new HashSet<>();
        for (int i = 0; i < 2000; i++) {
            fakerStudents.add(faker.name().firstName());
        }

        Graph<String,String> graph = GraphBuilder.empty().buildGraph();

        fakerProjects.forEach(graph::addVertex);
        fakerStudents.forEach(graph::addVertex);

        Random random = new Random();

        //setting graph edges
        fakerStudents.forEach(student -> {
            for(int i = 0; i < random.nextInt(fakerProjects.size() - 1) + 1; i++) {
                graph.addEdge(student, new ArrayList<>(fakerProjects).get(random.nextInt(fakerProjects.size() - 1) + 1));
            }
        });

        HopcroftKarpMaximumMatching maximumMatching = new HopcroftKarpMaximumMatching(graph);

        Matching matching = maximumMatching.getMatching();
        System.out.println(matching.isValid());
    }

}
