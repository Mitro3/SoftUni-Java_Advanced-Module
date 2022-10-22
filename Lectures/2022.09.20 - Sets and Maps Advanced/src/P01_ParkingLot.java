import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] carsData = input.split(", ");
            String command = carsData[0];
            String registration = carsData[1];

            switch (command) {
                case "IN":
                    set.add(registration);
                    break;
                case "OUT":
                    set.remove(registration);
                    break;
            }

            input = scanner.nextLine();
        }

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String cars : set) {
                System.out.println(cars);
            }
        }
    }
}
