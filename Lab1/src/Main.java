

public class Main {
    public static void main(String[] args) {

        //Mandatory Lab Part
        System.out.println("Hello world\n");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        n = n * 3;
        n = n + Integer.parseInt("10101");
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;

        int result = sumOfDigits(n);

        while (result > 9) {
            result = sumOfDigits(result);
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

        //Homework Lab Part
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


    private static int sumOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
}
