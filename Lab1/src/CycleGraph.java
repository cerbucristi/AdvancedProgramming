import java.util.Arrays;

/**
 * @author cerbu cristi
 */
public class CycleGraph {

    int n;
    private int[][] matrixCycleGraph;

    public CycleGraph(int n) {
        this.n = n;
        matrixCycleGraph = initializeMatrix(n);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        CycleGraph cycleGraph = new CycleGraph(n);

        System.out.println("Matricea de adiacenta: \n");
        System.out.println(Arrays.deepToString(cycleGraph.matrixCycleGraph) + "\n");

        // Compute the powers A^2, A^3, ..., A^n
        int[][] powMatrix = new int[n][n];
        cycleGraph.matrixCopy(powMatrix, cycleGraph.getMatrixCycleGraph());
        for (int k = 2; k <= n; k++) {
            powMatrix = cycleGraph.multiplyMatrix(powMatrix, cycleGraph.matrixCycleGraph);
            System.out.println("matrix^" + k + ":");
            for (int[] row : powMatrix) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    private void matrixCopy(int[][]toCopy, int[][] from){
        int n = from[0].length;
        for (int i = 0; i < n; i++) {
            System.arraycopy(from[i], 0, toCopy[i], 0, n);
        }
    }
    private int[][] initializeMatrix(int n) {
        int[][] retMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            retMatrix[i][(i + 1) % n] = 1;
            retMatrix[(i + 1) % n][i] = 1;
        }
        return retMatrix;
    }

    private int[][] multiplyMatrix(int[][] powMatrix, int[][] simpleMatrix){
        int n = simpleMatrix[0].length;
        int[][] retMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    retMatrix[i][j] += powMatrix[i][k] * simpleMatrix[k][j];
                }
            }
        }

        return retMatrix;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getMatrixCycleGraph() {
        return matrixCycleGraph;
    }

    public void setMatrixCycleGraph(int[][] matrixCycleGraph) {
        this.matrixCycleGraph = matrixCycleGraph;
    }
}
