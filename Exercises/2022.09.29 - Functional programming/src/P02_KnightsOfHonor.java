import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02_KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> names = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        Consumer<String> consumer = name -> System.out.printf("Sir %s%n", name);

        names.forEach(consumer);
    }
}
