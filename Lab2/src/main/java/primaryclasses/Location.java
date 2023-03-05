package primaryclasses;

import enums.LocationTypes;

import java.util.Objects;

public class Location {
    private String strLocationName;
    private LocationTypes locationType;
    private double xCoordinate;
    private double yCoordinate;

    public Location(String strLocationName, LocationTypes locationType, double xCoordinate, double yCoordinate) {
        this.strLocationName = strLocationName;
        this.locationType = locationType;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "primaryclasses.Location{" + "\n" +
                "strLocationName='" + strLocationName + '\'' + "\n" +
                ", locationType=" + locationType + "\n" +
                ", xCoordinate=" + xCoordinate + "\n" +
                ", yCoordinate=" + yCoordinate + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.xCoordinate, xCoordinate) == 0
                && Double.compare(location.yCoordinate, yCoordinate) == 0
                && strLocationName.equals(location.strLocationName)
                && locationType == location.locationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strLocationName, locationType, xCoordinate, yCoordinate);
    }

    public LocationTypes getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationTypes locationType) {
        this.locationType = locationType;
    }

    public String getStrLocationName() {
        return strLocationName;
    }

    public void setStrLocationName(String strLocationName) {
        this.strLocationName = strLocationName;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
