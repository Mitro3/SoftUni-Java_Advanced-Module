package P04_RawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            String input = scanner.nextLine();
            String[] carData = input.split("\\s+");

            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);

            Map<Double, Integer> currTiresData = new LinkedHashMap<>();
            currTiresData.put(tire1Pressure, tire1Age);
            currTiresData.put(tire2Pressure, tire2Age);
            currTiresData.put(tire3Pressure, tire3Age);
            currTiresData.put(tire4Pressure, tire4Age);

            Car car = new Car(model,
                    new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType),
                    new Tires(currTiresData));

            cars.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                List<Car> carsWithFragileCargo = cars.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("fragile")).collect(Collectors.toList());

                for (Car car : carsWithFragileCargo) {
                    Map<Double, Integer> flatTires = car.getTires().entrySet().stream().filter(p -> p.getKey() < 1)
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    if (!flatTires.isEmpty()) {
                        System.out.println(car.getModel());
                    }
                }
                break;

            case "flamable":
                List<Car> carWithFlammableCargo = cars.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("flamable")).collect(Collectors.toList());
                for (Car car : carWithFlammableCargo) {
                    int currPower = car.getEngine().getEnginePower();
                    if (currPower > 250) {
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
}
