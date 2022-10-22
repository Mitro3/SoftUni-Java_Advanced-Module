package exam_23_October_2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCoctails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        input = scanner.nextLine();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(i -> freshnessLevelStack.push(i));

        Map<String, Integer> coctails = new TreeMap<>();

        while (!freshnessLevelStack.isEmpty() && !ingredientsQueue.isEmpty()) {
            int ingredientToMix = ingredientsQueue.poll();

            if (ingredientToMix == 0) {
                continue;
            }

            int freshnessLevelToMix = freshnessLevelStack.pop();
            int multiplicationResult = ingredientToMix * freshnessLevelToMix;

            switch (multiplicationResult) {
                case 400:
                    coctails.putIfAbsent("High Fashion", 0);
                    coctails.put("High Fashion", coctails.get("High Fashion") + 1);
                    break;
                case 300:
                    coctails.putIfAbsent("Apple Hinny", 0);
                    coctails.put("Apple Hinny", coctails.get("Apple Hinny") + 1);
                    break;
                case 250:
                    coctails.putIfAbsent("The Harvest", 0);
                    coctails.put("The Harvest", coctails.get("The Harvest") + 1);
                    break;
                case 150:
                    coctails.putIfAbsent("Pear Sour", 0);
                    coctails.put("Pear Sour", coctails.get("Pear Sour") + 1);
                    break;
                default:
                    ingredientToMix += 5;
                    ingredientsQueue.offer(ingredientToMix);
            }
        }

        if (coctails.size() != 4) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }

        if (!ingredientsQueue.isEmpty()) {
            System.out.printf("Ingredients left: %d%n", ingredientsQueue.stream().mapToInt(Integer::intValue).sum());
        }

        coctails.entrySet().forEach(c -> System.out.printf("# %s --> %d%n", c.getKey(), c.getValue()));
    }
}
