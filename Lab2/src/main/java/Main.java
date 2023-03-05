import enums.LocationTypes;
import enums.RoadTypes;
import locations.City;
import primaryclasses.Location;
import primaryclasses.Problem;
import primaryclasses.Road;
import roads.Highway;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
        Mandatory Lab Part
         */
        List<Location> locations;
        Location location1 = new Location("Iasi", LocationTypes.CITY, 3.5, 43);
        Location location2 = new Location("Luton Airport", LocationTypes.AIRPORT, 27, 25.4);

        locations = new LinkedList<>();
        locations.add(location1);
        locations.add(location2);

        Road road1 = new Road("DJ2", RoadTypes.AUTOBAHN, locations, 30, 70);
        Road road2 = new Road("DN1", RoadTypes.FREEWAY, locations, 119.5, 110);


//        System.out.println(location1);
//        System.out.println(location2);
//        System.out.println(road1);
//        System.out.println(road2);

        /*
        Homework Lab Part
         */

        Location location3 = new City("New York", -20, -10, 1000);
        List<Location> locations2 = new LinkedList<>();
        locations2.add(location2);
        locations2.add(location3);

        Road road3 = new Highway("HIGHWAY2", locations2, 59.0, 130, (short) 50);
        Problem problem = new Problem();
        problem.addLocations(locations);
        problem.addRoads(Collections.singletonList(road1));
        problem.addRoads(Collections.singletonList(road2));

//        System.out.println(problem.getLocations());
//        System.out.println(problem.getRoads());
        problem.removeLocations(Collections.singletonList(location1));
        problem.addLocations(Collections.singletonList(location1));
        problem.addLocations(Collections.singletonList(location3));
        problem.addRoads(Collections.singletonList(road3));
//        System.out.println(problem.getLocations());
        problem.setStartLocation(location1);
        problem.setEndLocation(location3);
        if (problem.isValidProblem()) {
            System.out.println(problem.findMyWay());
        }


    }
}
