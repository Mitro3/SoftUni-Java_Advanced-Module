package retakeExam_13_April_2022;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        input = scanner.nextLine();

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);

        Map<String, Integer> forgedSwords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steelToMix = steelQueue.poll();
            int carbonToMix = carbonStack.pop();

            int sum = steelToMix + carbonToMix;
            String swordName = "";
            if (sum == 110) {
                swordName = "Sabre";
                increaseSwordCount(forgedSwords, swordName);
            } else if (sum == 90) {
                swordName = "Katana";
                increaseSwordCount(forgedSwords, swordName);
            } else if (sum == 80) {
                swordName = "Shamshir";
                increaseSwordCount(forgedSwords, swordName);
            } else if (sum == 70) {
                swordName = "Gladius";
                increaseSwordCount(forgedSwords, swordName);
            } else {
                carbonToMix += 5;
                carbonStack.push(carbonToMix);
            }
        }

        if (!forgedSwords.isEmpty()) {
            int sum = forgedSwords.values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("You have forged %d swords.%n", sum);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            StringBuilder sb = new StringBuilder("Steel left: ");
            for (Integer integer : steelQueue) {
                sb.append(String.join(", ", integer.toString()));
            }
            System.out.println(sb.toString());
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbonStack.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }

        forgedSwords.entrySet().forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));

    }

    private static void increaseSwordCount(Map<String, Integer> map, String name) {
        map.putIfAbsent(name, 0);
        map.put(name, map.get(name) + 1);
    }
}
