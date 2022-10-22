package retakeExam_18_August_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Long> licensePlates = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .map(Long::parseLong)
                .forEach(licensePlates::offer);

        input = scanner.nextLine();

        ArrayDeque<Long> cars = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .map(Long::parseLong)
                .forEach(cars::push);

        int registeredCars = 0;
        int daysCount = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            daysCount++;
            long carsToRegister = cars.pop();
            long platesAvailable = licensePlates.poll();
            long carsLeft = 0;
            long platesLeft = 0;

            if (platesAvailable < carsToRegister * 2) {
                carsLeft = carsToRegister - platesAvailable / 2;
                cars.addLast(carsLeft);
                carsToRegister = platesAvailable / 2;
            } else if (platesAvailable > carsToRegister * 2){
                platesLeft = platesAvailable - carsToRegister * 2;
                licensePlates.offer(platesLeft);
            }
            registeredCars += carsToRegister;
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, daysCount);

        if (!licensePlates.isEmpty()) {
            int sum = 0;
            while (!licensePlates.isEmpty()) {
                sum += licensePlates.poll();
            }
            System.out.printf("%d license plates remain!%n", sum);
        } else if (!cars.isEmpty()) {
            int sum = 0;
            while (!cars.isEmpty()) {
                sum += licensePlates.pop();
            }
            System.out.printf("%d cars remain without license plates!", sum);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
