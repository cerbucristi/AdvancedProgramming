import java.util.List;

public class Cell {

    private List<Token> storedTokens;
    private boolean visited;

    public Cell() {
        this.visited = false;
    }

    public List<Token> getStoredTokens() {
        return storedTokens;
    }

    public void setStoredTokens(List<Token> storedTokens) {
        this.storedTokens = storedTokens;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
