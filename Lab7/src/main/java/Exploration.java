import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exploration {

    private final int n = 10;

    private final SharedMemory mem = new SharedMemory(n*n*n);
    private final ExplorationMap map = new ExplorationMap(n);
    private final List<Robot> robots = new ArrayList<>();

    private void addRobot (Robot robot) {
        //randomly choose a position for the robot on the map
        Random random = new Random();
        int randRow;
        int randCol;
        robots.add(robot);
        robot.setExplore(this);

        do {
            randRow = random.nextInt(n-1);
            randCol = random.nextInt(n-1);
        } while (!map.visit(randRow, randCol, robot));
    }
    public void start() {
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            thread.start();
            robot.setRunning(true);
        }
    }
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

    public int getN() {
        return n;
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }
}