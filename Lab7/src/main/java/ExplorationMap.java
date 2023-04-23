import java.util.Arrays;

public class ExplorationMap {

    private final Cell[][] matrix;

    public ExplorationMap(int n) {
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            Cell cell = matrix[row][col];
            if (!cell.isVisited()) {
                cell.setStoredTokens(robot.explore.getMem().extractTokens(robot.explore.getN()));
                cell.setVisited(true);
                System.out.printf("Cell from row %d and column %d was successfully visited!\n", row, col);
                return true;
            }
            return false;
        }
    }



    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
