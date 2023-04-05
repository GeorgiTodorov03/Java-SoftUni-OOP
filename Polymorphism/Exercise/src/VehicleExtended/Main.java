package VehicleExtended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        vehicleMap.put("Bus", getVehicle(scanner));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String vehicleType = commandParts[1];
            double distance = Double.parseDouble(commandParts[2]);

            switch (commandParts[0]) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(distance));
                    break;

                case "DriveEmpty":
                    Bus bus = (Bus) vehicleMap.get(vehicleType);
                    System.out.println(bus.driveEmpty(distance));
                    break;

                case "Refuel":
                    double litres = Double.parseDouble(commandParts[2]);
                    try {

                        vehicleMap.get(vehicleType).refuel(litres);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, tankCapacity);

            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, tankCapacity);

            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, tankCapacity);

            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}
