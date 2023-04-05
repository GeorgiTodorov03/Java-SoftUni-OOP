package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        double carFuelQuantity = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);

        Vehicle car = new Car(carFuelQuantity, carFuelConsumption);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);

        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");

            switch (commandParts[0]) {
                case "Drive":
                    double distance = Double.parseDouble(commandParts[2]);
                    if (commandParts[1].equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double litres = Double.parseDouble(commandParts[2]);
                    if (commandParts[1].equals("Car")) {
                        car.refuel(litres);
                    } else {
                        truck.refuel(litres);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
