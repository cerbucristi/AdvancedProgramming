package others;

import java.util.*;

public class Graph<T> {
    private final Map<T, Set<T>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyMap.containsKey(vertex)) {
            adjacencyMap.put(vertex, new HashSet<>());
        }
    }

    public void addEdge(T vertex1, T vertex2) {
        adjacencyMap.get(vertex1).add(vertex2);
        adjacencyMap.get(vertex2).add(vertex1);
    }

    public Set<T> getNeighbors(T vertex) {
        return adjacencyMap.get(vertex);
    }
}
