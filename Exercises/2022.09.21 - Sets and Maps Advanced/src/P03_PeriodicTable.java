import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] chemCompounds = input.split("\\s+");

            for (String element : chemCompounds) {
                chemElements.add(element);
            }
        }

        System.out.println(String.join(" ", chemElements));
    }
}
