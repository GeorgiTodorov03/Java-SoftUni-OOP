import java.util.Optional;
import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int startingRange = Integer.parseInt(range[0]);
        int endRange = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", startingRange, endRange);



        boolean isValid = false;

        while (!isValid) {
            String data = scanner.nextLine();

            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(data));
            } catch (NumberFormatException ignored) {
            }

            String output = "Invalid number: " + data;

            if (isInRange(startingRange, endRange, number)) {
                isValid = true;
                output = "Valid number: " + number;

            }
            System.out.println(output);
        }
    }

    private static boolean isInRange(int startingRange, int endRange, Optional<Integer> number) {
        return number.isPresent() && number.get() >= startingRange && number.get() <= endRange;
    }
}
