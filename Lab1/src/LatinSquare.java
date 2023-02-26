/**
 * @author cerbu cristi
 * Homework Lab Part
 */

public class LatinSquare {

    private int n;
    private int[][] matrixLatinSquare;


    public LatinSquare(int n) {
        this.n = n;
        matrixLatinSquare = initializeMatrix(n);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        LatinSquare latinSquare = new LatinSquare(Integer.parseInt(args[0]));
        int[][] matrixLatinSquare = latinSquare.getMatrixLatinSquare();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            for (int j = 0; j < Integer.parseInt(args[0]); j++) {
                stringBuilder.append(matrixLatinSquare[i][j]);
                if (j == Integer.parseInt(args[0]) - 1) {
                    if (Integer.parseInt(args[0]) < 1000) {
                        System.out.println("Line " + (i + 1) + ": " + stringBuilder + "\n");
                    }
                    stringBuilder.setLength(0);
                }
            }
        }

        for (int j = 0; j < Integer.parseInt(args[0]); j++) {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                stringBuilder.append(matrixLatinSquare[i][j]);
                if (i == Integer.parseInt(args[0]) - 1) {
                    if (Integer.parseInt(args[0]) < 1000) {
                        System.out.println("Column " + (j + 1) + ": " + stringBuilder + "\n");
                    }
                    stringBuilder.setLength(0);
                }
            }
        }

        long endTime = System.nanoTime();

        if (Integer.parseInt(args[0]) >= 1000) {
            System.out.println("Duration: " + (endTime - startTime) + " nanoseconds");
        }
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
