package roads;

import enums.RoadTypes;
import primaryclasses.Location;
import primaryclasses.Road;

import java.util.List;

public class Highway extends Road {
    private short minimumSpeedLimit;

    public Highway(String roadName, List<Location> availableLocations, double length, int speedLimit, short minimumSpeedLimit) {
        super(roadName, RoadTypes.HIGHWAY, availableLocations, length, speedLimit);
        this.minimumSpeedLimit = minimumSpeedLimit;
    }

    public short getMinimumSpeedLimit() {
        return minimumSpeedLimit;
    }

    public void setMinimumSpeedLimit(short minimumSpeedLimit) {
        this.minimumSpeedLimit = minimumSpeedLimit;
    }
}
