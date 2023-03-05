package primaryclasses;

import primaryclasses.Location;
import primaryclasses.Road;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private final List<Location> locations;
    private final List<Road> roads;

    private Location startLocation;

    private Location endLocation;

    public Problem() {
        locations = new LinkedList<>();
        roads = new LinkedList<>();
    }

    public boolean isValidProblem() {
        if (locations.size() < 2) {
            System.out.printf("To few locations specified: %s, you need at least 2!%n", locations.size());
            return false;
        }
        if (roads.size() < 1) {
            System.out.printf("No road specified, you need at least 1!%n");
            return false;
        }
        if (startLocation == null) {
            System.out.print("Not a start location specified!");
            return false;
        }
        if (!locations.contains(startLocation)) {
            System.out.printf("The start location %s is not found in the locations list!", startLocation.getStrLocationName());
            return false;
        }
        if (endLocation == null) {
            System.out.print("Not a end location specified!");
            return false;
        }
        if (!locations.contains(endLocation)) {
            System.out.printf("The end location %s is not found in the locations list!", endLocation.getStrLocationName());
            return false;
        }
        if (startLocation.equals(endLocation)) {
            System.out.print("Start location should be different from the end location");
            return false;
        }
        return true;
    }

    public String findMyWay() {
        /*
        checking if we have a direct road from start to end location
         */
        List<Location> searchedLocations = new LinkedList<>();
        searchedLocations.add(startLocation);
        searchedLocations.add(endLocation);
        for (Road road : roads) {
            if (road.getAvailableLocations().containsAll(searchedLocations)) {
                return String.format("The corresponding road from %s to %s is %s", startLocation.getStrLocationName(),
                        endLocation.getStrLocationName(), road.getRoadName());
            }
        }
        /*
        apply the main algorithm which will be a dfs
         */
        Map<Location, Boolean> visited = new HashMap<>();
        for (Location location : locations) {
            visited.put(location, false);
        }
        List<Road> myRoad = new ArrayList<>();
        dfsSearch(startLocation, endLocation, visited, myRoad);

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        for (Road road : myRoad) {
            stringBuilder.append(road.getRoadName());
            if (i != myRoad.size() - 1) {
                stringBuilder.append(" -> ");
            }
            i++;
        }

        return String.format("The corresponding road from %s to %s is %s", startLocation.getStrLocationName(),
                endLocation.getStrLocationName(), stringBuilder);
    }

    private boolean dfsSearch(Location start, Location end, Map<Location, Boolean> visited, List<Road> path) {
        visited.put(start, true);
        if (start.equals(end)) {
            return true;
        }
        for (Road road : roads) {
            if (road.getAvailableLocations().get(0).equals(start) && !visited.get(road.getAvailableLocations().get(1))) {
                path.add(road);
                if (dfsSearch(road.getAvailableLocations().get(1), end, visited, path)) {
                    return true;
                }
                path.remove(road);
            }
        }
        return false;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocations(List<Location> locations) {
        for (Location givenLocation : locations) {
            for (Location existingLocation : this.locations) {
                if (givenLocation.equals(existingLocation)) {
                    throw new IllegalArgumentException(String.format("Location %s that you're trying to add already exists!",
                            givenLocation.getStrLocationName()));
                }
            }
        }
        this.locations.addAll(locations);
    }

    public void removeLocations(List<Location> locations) {
        this.locations.removeAll(locations);
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void addRoads(List<Road> roads) {
        for (Road givenRoad : roads) {
            for (Road existingRoad : this.roads) {
                if (givenRoad.equals(existingRoad)) {
                    throw new IllegalArgumentException(String.format("Road %s that you're trying to add already exists!",
                            givenRoad.getRoadName()));
                }
            }
        }
        this.roads.addAll(roads);
    }

    public void removeRoads(List<Road> roads) {
        this.roads.removeAll(roads);
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
}
