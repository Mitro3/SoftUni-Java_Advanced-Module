import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] data = input.split("\\s+");

        int firstSetSize = Integer.parseInt(data[0]);
        int secondSetSize = Integer.parseInt(data[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        readSet(scanner, firstSet, firstSetSize);
        readSet(scanner, secondSet, secondSetSize);

//
//        for (String element : firstSet) {
//            if (secondSet.contains(element)) {
//                System.out.print(element + " ");
//            }
//        }

        firstSet.retainAll(secondSet);

        for (String s : firstSet) {
            System.out.print(s + " ");
        }
    }

    private static void readSet(Scanner scanner, Set<String> set, int setSize) {
        for (int i = 0; i < setSize; i++) {
            String input = scanner.nextLine();
            set.add(input);
        }
    }
}
