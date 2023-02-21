import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world\n");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        n = n * 3;
        n = n + Integer.parseInt("10101");
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;

        int result = sumOfDigits(n);

        while (result > 9){
            result = sumOfDigits(result);
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    private static int sumOfDigits(int n){
        int sum = 0;

        while (n > 0){
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
}
