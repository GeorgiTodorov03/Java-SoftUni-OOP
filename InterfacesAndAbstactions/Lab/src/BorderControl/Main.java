package BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length < 3) {
                String model = data[0];
                String id = data[1];

                identifiable = new Robot(model, id);
                identifiables.add(identifiable);
            } else {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);
                identifiables.add(identifiable);
            }

            input = scanner.nextLine();
        }

        String targetId = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(targetId))
                .forEach(System.out::println);


    }
}
