import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\s+");

        int elementsToPush = Integer.parseInt(inputArr[0]);
        int elementsToPop = Integer.parseInt(inputArr[1]);
        int elementsToSearch = Integer.parseInt(inputArr[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String numbers = scanner.nextLine();
        String[] numbersArr = numbers.split("\\s+");

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(Integer.parseInt(numbersArr[i]));
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (stack.contains(elementsToSearch)) {
                System.out.println(true);
            } else {
                //int minElement = Collections.min(stack);

                int minElement = Integer.MAX_VALUE;

                for (Integer number : stack) {
                    if (number < minElement) {
                        minElement = number;
                    }
                }
                System.out.println(minElement);
            }
        }
    }
}

