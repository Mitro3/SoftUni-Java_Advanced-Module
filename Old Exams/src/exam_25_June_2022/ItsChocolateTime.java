package exam_25_June_2022;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Double::parseDouble)
                .forEach(milkQueue::offer);

        input = scanner.nextLine();

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);

        Map<String, Integer> drinksCount = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milkToMix = milkQueue.poll();
            double cacaoToMix = cacaoStack.pop();

            double cacaoPercentage = 100 * cacaoToMix / (milkToMix + cacaoToMix);
            String drinkName = "";

            if (cacaoPercentage == 100) {
                drinkName = "Baking Chocolate";
                putDrinkInMap(drinksCount, drinkName);
            } else if (cacaoPercentage == 50) {
                drinkName = "Dark Chocolate";
                putDrinkInMap(drinksCount, drinkName);
            } else if (cacaoPercentage == 30) {
                drinkName = "Milk Chocolate";
                putDrinkInMap(drinksCount, drinkName);
            } else {
                milkToMix += 10;
                milkQueue.addLast(milkToMix);
            }

        }

        if (drinksCount.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            drinksCount.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            drinksCount.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
        }


    }

    private static void putDrinkInMap(Map<String, Integer> drinksCount, String name) {
        if (!drinksCount.containsKey(name)) {
            drinksCount.put(name, 1);
        } else {
            int updatedQuantity = drinksCount.get(name);
            drinksCount.put(name, updatedQuantity + 1);
        }
    }
}
