package exam_19_February_2022;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .forEach(vowelsQueue::offer);

        input = scanner.nextLine();
        ArrayDeque<String> consonantStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .forEach(consonantStack::push);

        while (!consonantStack.isEmpty()) {
            String currVowel = vowelsQueue.poll();
            String currConsonant = consonantStack.pop();

            for (int i = 0; i < words.length; i++) {
                String currWord = words[i];
                int indexOfVowel = currWord.indexOf(currVowel);
                int indexOfConsonant = currWord.indexOf(currConsonant);

                if (indexOfVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexOfVowel) + currVowel + foundWords[i].substring(indexOfVowel + 1);
                }

                if (indexOfConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexOfConsonant) + currConsonant + foundWords[i].substring(indexOfConsonant + 1);
                }
            }

            vowelsQueue.offer(currVowel);
        }

        List<String> output = Arrays.stream(foundWords)
                .filter(w -> !w.contains("*"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(o -> System.out.println(o));
    }

}
