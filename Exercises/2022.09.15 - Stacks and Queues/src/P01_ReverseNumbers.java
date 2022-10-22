import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputArr = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : inputArr) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
