import java.util.ArrayDeque;
import java.util.Scanner;

public class P04_BasiqQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split("\\s+");

        int elementsToOffer = Integer.parseInt(inputArr[0]);
        int elementsToPoll = Integer.parseInt(inputArr[1]);
        int elementsToSearch = Integer.parseInt(inputArr[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String numbers = scanner.nextLine();
        String[] numbersArr = numbers.split("\\s+");

        for (int i = 0; i < elementsToOffer; i++) {
            queue.offer(Integer.parseInt(numbersArr[i]));
        }

        for (int i = 0; i < elementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(elementsToSearch)) {
                System.out.println(true);
            } else {
                int minElement = Integer.MAX_VALUE;

                for (Integer number : queue) {
                    if (number < minElement) {
                        minElement = number;
                    }
                }
                System.out.println(minElement);
            }
        }
    }
}
