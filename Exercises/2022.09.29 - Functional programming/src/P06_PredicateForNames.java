import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNameLength = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        List<String> names = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        Predicate<String> validNames = name -> name.length() <= maxNameLength;

        names.stream().filter(validNames).forEach(System.out::println);
    }
}
