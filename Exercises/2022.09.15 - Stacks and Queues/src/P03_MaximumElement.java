import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            switch (inputArr[0]) {
                case "1":
                    stack.push(Integer.parseInt(inputArr[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }

        }
    }
}
