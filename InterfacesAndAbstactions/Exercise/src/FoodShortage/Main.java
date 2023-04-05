package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> people = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Buyer buyer;

            if (data.length == 4) {
                String id = data[2];
                String birthDate = data[3];
                buyer = new Citizen(name, age, id, birthDate);

            } else {
                String group = data[2];
                buyer = new Rebel(name, age, group);
            }
            people.put(name, buyer);

            String targetName = scanner.nextLine();
            while (!targetName.equals("End")) {
                Buyer currentBuyer = people.get(targetName);

                if (currentBuyer != null) {
                    currentBuyer.buyFood();
                }

                targetName = scanner.nextLine();
            }

            int totalFood = people.values().stream()
                    .mapToInt(Buyer::getFood)
                    .sum();

            System.out.println(totalFood);
        }
    }
}
