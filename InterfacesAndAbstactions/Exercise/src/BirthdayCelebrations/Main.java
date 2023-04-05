package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String type = data[0];

            Birthable birthable;
            switch (type) {
                case "Citizen":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthdate = data[4];
                    birthable = new Citizen(name, age, id, birthdate);
                    birthables.add(birthable);
                    break;
                case "Pet":
                    String petName = data[1];
                    String petBirthDate = data[2];
                    birthable = new Pet(petName, petBirthDate);
                    birthables.add(birthable);
                    break;
                case "Robot":
                    String model = data[1];
                    String robotId = data[2];
                    break;
            }
            input = scanner.nextLine();
        }

        String targetDate = scanner.nextLine();

        birthables.stream()
                .map(Birthable::getBirthDate)
                .filter(birthDate -> birthDate.endsWith(targetDate))
                .forEach(System.out::println);
    }
}
