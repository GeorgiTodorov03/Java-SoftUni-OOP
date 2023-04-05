import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            double sqrt = calcSqrt(number);
            System.out.printf("%.2f%n", sqrt);
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double calcSqrt(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt;
    }
}
