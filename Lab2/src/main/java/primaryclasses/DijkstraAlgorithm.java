package primaryclasses;

import java.util.*;

public class DijkstraAlgorithm extends Algorithm {


    public DijkstraAlgorithm(Problem problem) {
        super(problem);
    }

    @Override
    public Solution solve() {
        return new Solution(dijkstra(problem.getStartLocation(), problem.getEndLocation()));
    }


    /**
     * Finds the shortest road path from start point to end point using the Dijkstra algorithm technique
     * Main logic is based on a priority queue with a comparator by road length
     * @param start is the start point in finding the shortest path road
     * @param end is the end point in finding the shortest path road
     * @return the list of merged locations that describe the shortest path road from start to end (by road length)
     */
    private List<Location> dijkstra(Location start, Location end) {
        Map<Location, Double> distances = new HashMap<>();
        Map<Location, Road> previousRoads = new HashMap<>();
        PriorityQueue<Location> pq = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Location location : problem.getLocations()) {
            distances.put(location, Double.MAX_VALUE);
            previousRoads.put(location, null);
        }
        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Location current = pq.poll();
            if (current.equals(end)) {
                break;
            }
            for (Road road : getAdjacentRoads(current)) {
                double newDistance = distances.get(current) + road.getLength();
                if (newDistance < distances.get(road.getAvailableLocations().get(1))) {
                    distances.put(road.getAvailableLocations().get(1), newDistance);
                    previousRoads.put(road.getAvailableLocations().get(1), road);
                    pq.add(road.getAvailableLocations().get(1));
                }
            }
        }

        return buildShortestPath(previousRoads, start, end);
    }

    private List<Road> getAdjacentRoads(Location location) {
        List<Road> adjacentRoads = new ArrayList<>();
        for (Road road : problem.getRoads()) {
            if (road.getAvailableLocations().get(0).equals(location) || road.getAvailableLocations().get(1).equals(location)) {
                adjacentRoads.add(road);
            }
        }
        return adjacentRoads;
    }

    private List<Location> buildShortestPath(Map<Location, Road> previousRoads, Location start, Location end) {
        List<Location> mergedLocations = new ArrayList<>();
        Road currentRoad = previousRoads.get(end);
        while (currentRoad != null) {
            mergedLocations.add(0, currentRoad.getAvailableLocations().get(1));
            currentRoad = previousRoads.get(currentRoad.getAvailableLocations().get(0));
        }
        mergedLocations.add(0, start);
        return mergedLocations;
    }
}
