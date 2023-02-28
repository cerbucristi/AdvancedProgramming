import enums.LocationTypes;

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
        return "Location{" + "\n" +
                "strLocationName='" + strLocationName + '\'' + "\n" +
                ", locationType=" + locationType + "\n" +
                ", xCoordinate=" + xCoordinate + "\n" +
                ", yCoordinate=" + yCoordinate + "\n" +
                '}';
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
