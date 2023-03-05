package roads;

import enums.RoadTypes;
import primaryclasses.Location;
import primaryclasses.Road;

import java.util.List;

public class Metropolitan extends Road {
    private short maximumTonnageLimit;

    public Metropolitan(String roadName, List<Location> availableLocations, double length, int speedLimit, short maximumTonnageLimit) {
        super(roadName, RoadTypes.METROPOLITAN, availableLocations, length, speedLimit);
        this.maximumTonnageLimit = maximumTonnageLimit;
    }

    public short getMaximumTonnageLimit() {
        return maximumTonnageLimit;
    }

    public void setMaximumTonnageLimit(short maximumTonnageLimit) {
        this.maximumTonnageLimit = maximumTonnageLimit;
    }
}
