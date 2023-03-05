package primaryclasses;

import enums.RoadTypes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Road {

    private String roadName;
    private RoadTypes roadType;
    private List<Location> availableLocations;

    private double length;

    private int speedLimit;

    public Road(String roadName, RoadTypes roadType, List<Location> availableLocations, double length, int speedLimit) {
        this.roadName = roadName;
        this.roadType = roadType;
        if (availableLocations.size() != 2) {
            throw new IllegalArgumentException(String.format("A road could only connect exactly 2 different points! You specified %s locations: %s",
                    availableLocations.size(), availableLocations));
        }
        this.availableLocations = availableLocations;
        double locationDistance = getLocationEuclideanDistance(availableLocations);
        if (length < locationDistance) {
            throw new IllegalArgumentException(String.format("primaryclasses.Road length is too short for the specified locations: %s smaller than %s",
                    length, locationDistance));
        }
        this.length = length;
        this.speedLimit = speedLimit;
    }

    protected double getLocationEuclideanDistance(List<Location> locations) {
        return Math.sqrt(Math.pow((locations.get(0).getxCoordinate() - locations.get(1).getxCoordinate()), 2) +
                Math.pow((locations.get(0).getyCoordinate() - locations.get(1).getyCoordinate()), 2));
    }

    @Override
    public String toString() {
        return "primaryclasses.Road{" +
                "roadName='" + roadName + '\'' +
                ", roadType=" + roadType +
                ", availableLocations=" +
                availableLocations.stream().map(Location::getStrLocationName).collect(Collectors.toList()) +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0
                && speedLimit == road.speedLimit
                && Objects.equals(roadName, road.roadName)
                && roadType == road.roadType
                && Objects.equals(availableLocations, road.availableLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadName, roadType, availableLocations, length, speedLimit);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
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
