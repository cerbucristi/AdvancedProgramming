package locations;

import enums.LocationTypes;
import primaryclasses.Location;

public class Airport extends Location {

    private int numberOfTerminals;

    public Airport(String strLocationName, double xCoordinate, double yCoordinate, int numberOfTerminals) {
        super(strLocationName, LocationTypes.AIRPORT, xCoordinate, yCoordinate);
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
}
