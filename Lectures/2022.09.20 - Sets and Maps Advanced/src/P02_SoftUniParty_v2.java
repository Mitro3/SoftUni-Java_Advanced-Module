import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> set = new TreeSet<>();

        while (!input.equals("PARTY")) {
            //In ASCII Table 0-9 is always before the letters. That's why using TreeSet will order first by number.
            set.add(input);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            set.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(set.size());

        for (String s : set) {
            System.out.println(s);
        }

    }
}
