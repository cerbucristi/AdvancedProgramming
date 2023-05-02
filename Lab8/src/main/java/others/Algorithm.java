package others;

import models.Album;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithm {

    /**
     * Generates maximal playlists of unrelated albums.
     *
     * @param albums    the set of albums to generate playlists from
     * @param limit     the maximum number of playlists to generate
     * @return          a list of maximal playlists
     */
    public static List<Playlist> generatePlaylists(Set<Album> albums, int limit) {

        Graph<Album> graph = new Graph<>();
        for (Album album : albums) {
            graph.addVertex(album);
        }
        for (Album album1 : albums) {
            for (Album album2 : albums) {
                if (!album1.equals(album2) && album1.isRelated(album2)) {
                    graph.addEdge(album1, album2);
                }
            }
        }

        // Find maximal stable sets (playlists) in the graph
        List<Playlist> playlists = new ArrayList<>();
        Set<Album> remainingVertices = new HashSet<>(albums);
        while (!remainingVertices.isEmpty()) {
            Set<Album> playlistVertices = findMaximalStableSet(graph, remainingVertices);
            if (playlistVertices.isEmpty()) {
                break;
            }
            Playlist playlist = new Playlist("Playlist " + (playlists.size() + 1), playlistVertices);
            playlists.add(playlist);
            remainingVertices.removeAll(playlistVertices);
        }

        return playlists;
    }

    /**
     * Finds a maximal stable set in the given graph.
     *
     * @param graph     the graph to find a maximal stable set in
     * @param vertices  the set of vertices to consider
     * @return          a maximal stable set
     */
    private static <T> Set<T> findMaximalStableSet(Graph<T> graph, Set<T> vertices) {
        Set<T> maximalStableSet = new HashSet<>();
        bronKerbosch(new HashSet<>(), vertices, new HashSet<>(), graph, maximalStableSet);
        return maximalStableSet;
    }

    /**
     * Bron-Kerbosch algorithm for finding all maximal cliques in a graph.
     */
    private static <T> void bronKerbosch(
            Set<T> r,
            Set<T> p,
            Set<T> x,
            Graph<T> graph,
            Set<T> maximalStableSet) {
        if (p.isEmpty() && x.isEmpty()) {
            if (r.size() > maximalStableSet.size()) {
                maximalStableSet.clear();
                maximalStableSet.addAll(r);
            }
        } else {
            for (T vertex : new HashSet<>(p)) {
                Set<T> neighbors = graph.getNeighbors(vertex);
                bronKerbosch(
                        union(r, vertex),
                        intersection(p, neighbors),
                        intersection(x, neighbors),
                        graph,
                        maximalStableSet);
                p.remove(vertex);
                x.add(vertex);
            }
        }
    }

    private static <T> Set<T> union(Set<T> a, T b) {
        Set<T> union = new HashSet<>(a);
        union.add(b);
        return union;
    }

    private static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

}
