import enums.LocationTypes;
import enums.RoadTypes;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Location> locations;
        Location location1 = new Location("Iasi", LocationTypes.CITY, 3.5, 43);
        Location location2 = new Location("Luton Airport", LocationTypes.AIRPORT, 27, 25.4);

        locations = new LinkedList<>();
        locations.add(location1);
        locations.add(location2);

        Road road1 = new Road(RoadTypes.AUTOBAHN, locations);
        Road road2 = new Road(RoadTypes.FREEWAY, locations);


        System.out.println(location1);
        System.out.println(location2);
        System.out.println(road1);
        System.out.println(road2);


    }
}
