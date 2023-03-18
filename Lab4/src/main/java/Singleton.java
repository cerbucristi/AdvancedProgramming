import java.util.Map;

public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    public Singleton newInstance () {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
