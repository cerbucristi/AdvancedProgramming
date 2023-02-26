/**
 * @author cerbu cristi
 */

public class LatinSquare {

    private int n;
    private int[][] matrixLatinSquare;


    public LatinSquare(int n) {
        this.n = n;
        matrixLatinSquare = initializeMatrix(n);
    }

    private int[][] initializeMatrix(int n) {
        int[][] retMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                retMatrix[i][j] = (j+i) % n + 1;
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

    public int[][] getMatrixLatinSquare() {
        return matrixLatinSquare;
    }

    public void setMatrixLatinSquare(int[][] matrixLatinSquare) {
        this.matrixLatinSquare = matrixLatinSquare;
    }
}
