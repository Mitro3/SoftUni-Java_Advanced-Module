import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);

            if (!symbolsMap.containsKey(currChar)) {
                symbolsMap.put(currChar, 1);
            } else {
                int currOccurrences = symbolsMap.get(currChar);
                symbolsMap.put(currChar, currOccurrences + 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : symbolsMap.entrySet()) {
            System.out.printf("%s: %d time/s%n", pair.getKey(), pair.getValue());
        }

    }
}
