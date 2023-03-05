package locations;

import enums.LocationTypes;
import primaryclasses.Location;

public class City extends Location {

    private int populationNumber;

    public City(String strLocationName, double xCoordinate, double yCoordinate, int populationNumber) {
        super(strLocationName, LocationTypes.CITY, xCoordinate, yCoordinate);
        this.populationNumber = populationNumber;
    }

    public int getPopulationNumber() {
        return populationNumber;
    }

    public void setPopulationNumber(int populationNumber) {
        this.populationNumber = populationNumber;
    }
}
