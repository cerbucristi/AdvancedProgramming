import enums.RoadTypes;

import java.util.List;

public class Road {

    RoadTypes roadType;
    List<Location> availableLocations;


    public Road(RoadTypes roadType, List<Location> availableLocations) {
        this.roadType = roadType;
        this.availableLocations = availableLocations;
    }

    @Override
    public String toString() {
        return "Road{" + "\n" +
                "roadType=" + roadType + "\n" +
                ", availableLocations=" + availableLocations + "\n" +
                '}';
    }

    public RoadTypes getRoadType() {
        return roadType;
    }

    public void setRoadType(RoadTypes roadType) {
        this.roadType = roadType;
    }

    public List<Location> getAvailableLocations() {
        return availableLocations;
    }

    public void setAvailableLocations(List<Location> availableLocations) {
        this.availableLocations = availableLocations;
    }


}
