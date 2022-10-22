import java.util.ArrayDeque;
import java.util.Scanner;

public class P03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> reminders = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.println("0");
        } else {
            while (decimal != 0) {
                reminders.push(decimal % 2);
                decimal /= 2;
            }
        }

        for (Integer reminder : reminders) {
            System.out.print(reminder);
        }

    }
}
