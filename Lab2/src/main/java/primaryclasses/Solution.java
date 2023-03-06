package primaryclasses;

import java.util.List;

public class Solution {

    private List<Location> route;

    public Solution(List<Location> route) {
        this.route = route;
    }

    public double computeLength(){
        Road road = new Road();
        return road.getLocationEuclideanDistance(route);
    }

    public List<Location> getRoute() {
        return route;
    }

    public void setRoute(List<Location> route) {
        this.route = route;
    }
}
