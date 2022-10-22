import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> vipSet = new TreeSet<>();
        Set<String> regularSet = new TreeSet<>();

        while (!input.equals("PARTY")) {
            boolean isVip = Character.isDigit(input.charAt(0));

            if (isVip) {
                vipSet.add(input);
            } else {
                regularSet.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            boolean isVip = Character.isDigit(input.charAt(0));

            if (isVip) {
                vipSet.remove(input);
            } else {
                regularSet.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vipSet.size() + regularSet.size());

        for (String s : vipSet) {
            System.out.println(s);
        }

        for (String s : regularSet) {
            System.out.println(s);
        }
    }
}
