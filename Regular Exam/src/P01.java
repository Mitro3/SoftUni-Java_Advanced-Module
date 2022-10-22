import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(caffeineStack::push);

        input = scanner.nextLine();
        ArrayDeque<Integer> energyDrinkQueue = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinkQueue::offer);

        int caffeineDrank = 0;

        while (!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int caffeineToDrank = caffeineStack.pop();
            int energyDrinkToDrank = energyDrinkQueue.poll();
            int result = caffeineToDrank * energyDrinkToDrank;
            int currSum = caffeineDrank + result;

            if (currSum <= 300) {
                caffeineDrank += result;
            } else {
                energyDrinkQueue.offer(energyDrinkToDrank);
                if (caffeineDrank - 30 >= 0) {
                    caffeineDrank -= 30;
                }
            }
        }

        if (!energyDrinkQueue.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinkQueue.toString().replaceAll("\\[","")
                    .replaceAll("]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineDrank);
    }
}
