package retakeExam_18_August_2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        input = scanner.nextLine();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(i -> ingredientsStack.push(i));

        Map<String, Integer> foods = new LinkedHashMap<>();

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquidToMix = liquidsQueue.poll();
            int ingredientToMix = ingredientsStack.pop();
            int sum = liquidToMix + ingredientToMix;
            foods.putIfAbsent("Biscuit", 0);
            foods.putIfAbsent("Cake", 0);
            foods.putIfAbsent("Pie", 0);
            foods.putIfAbsent("Pastry", 0);

            switch (sum) {
                case 100:
                    foods.put("Pie", foods.get("Pie") + 1);
                    break;
                case 75:
                    foods.put("Pastry", foods.get("Pastry") + 1);
                    break;
                case 50:
                    foods.put("Cake", foods.get("Cake") + 1);
                    break;
                case 25:
                    foods.put("Biscuit", foods.get("Biscuit") + 1);
                    break;
                default:
                    ingredientToMix += 3;
                    ingredientsStack.push(ingredientToMix);
            }

        }

        List<Map.Entry> emptyKeys = foods.entrySet().stream().filter(e -> e.getValue() == 0).collect(Collectors.toList());

        if (emptyKeys.isEmpty()) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }

        foods.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
