package exam_15_December_2021;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(malesStack::push);

        input = scanner.nextLine();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(femaleQueue::offer);

        int succMatches = 0;

        while (!malesStack.isEmpty() && !femaleQueue.isEmpty()) {
            int maleToMatch = malesStack.peek();
            int femaleToMatch = femaleQueue.peek();

            if (maleToMatch <= 0) {
                malesStack.pop();
                continue;
            } else if (femaleToMatch <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (maleToMatch % 25 == 0) {
                malesStack.pop();

                if (malesStack.isEmpty()) {
                    break;
                }

                malesStack.pop();
                continue;
            } else if (femaleToMatch % 25 == 0) {
                femaleQueue.poll();

                if (femaleQueue.isEmpty()) {
                    break;
                }

                femaleQueue.poll();
                continue;
            }

            if (maleToMatch != femaleToMatch) {
                maleToMatch -= 2;
                malesStack.pop();
                malesStack.push(maleToMatch);
            } else {
                malesStack.pop();
                succMatches++;
            }

            femaleQueue.poll();
        }

        System.out.printf("Matches: %d%n", succMatches);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(malesStack.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }

        if (femaleQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(femaleQueue.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }

    }
}
