package P05_CarSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCount = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();
        Set<Car> carSet = new LinkedHashSet<>();

        for (int i = 0; i < enginesCount; i++) {
            String input = scanner.nextLine();
            String[] engineData = input.split("\\s+");

            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = null;
            Engine engine = null;

            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
                engine = new Engine(engineModel, power, displacement, efficiency);

            } else if (engineData.length == 2) {
                engine = new Engine(engineModel, power);

            } else if (Character.isDigit(engineData[2].charAt(0))) {
                displacement = Integer.parseInt(engineData[2]);
                engine = new Engine(engineModel, power, displacement);

            } else if (Character.isLetter(engineData[2].charAt(0))) {
                efficiency = engineData[2];
                engine = new Engine(engineModel, power, efficiency);
            }

            engineList.add(engine);

        }

        int carsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carsCount; i++) {
            String input = scanner.nextLine();
            String[] carData = input.split("\\s+");

            String model = carData[0];
            String engine = carData[1];
            int weight = 0;
            String color = null;
            Car car = null;

            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
                car = new Car(model,
                        engineList.stream()
                                .filter(e -> engine.equals(e.getModel()))
                                .findAny()
                                .orElse(null),
                        weight,
                        color);

            } else if (carData.length == 2) {
                car = new Car(model,
                        engineList.stream()
                                .filter(e -> engine.equals(e.getModel()))
                                .findAny()
                                .orElse(null));

            } else if (Character.isDigit(carData[2].charAt(0))) {
                weight = Integer.parseInt(carData[2]);
                car = new Car(model,
                        engineList.stream()
                                .filter(e -> engine.equals(e.getModel()))
                                .findAny()
                                .orElse(null),
                        weight);

            } else if (Character.isLetter(carData[2].charAt(0))) {
                color = carData[2];
                car = new Car(model,
                        engineList.stream()
                                .filter(e -> engine.equals(e.getModel()))
                                .findAny()
                                .orElse(null),
                        color);
            }

            carSet.add(car);
        }

        for (Car car : carSet) {
            System.out.println(car);
        };
    }
}
