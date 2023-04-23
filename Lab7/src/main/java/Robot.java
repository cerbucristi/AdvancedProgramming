import java.util.Random;

public class Robot implements Runnable{

    private String name;
    private boolean running;
    Exploration explore;
    public Robot(String name) {
        this.name = name;
    }

    public void run() {
        while (running) {
            Random random = new Random();
            explore.getMap().visit(random.nextInt(explore.getN()-1), random.nextInt(explore.getN()-1), this);
//            make the robot sleep for some time;
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
