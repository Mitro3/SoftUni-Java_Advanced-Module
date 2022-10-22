import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> names = new LinkedHashSet<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            names.add(input);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
