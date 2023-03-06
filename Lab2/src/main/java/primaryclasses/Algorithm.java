package primaryclasses;

import java.util.List;

public abstract class Algorithm {

    protected Problem problem;

    public Algorithm(Problem problem) {
        this.problem = problem;
    }

    public abstract Solution solve();
}
