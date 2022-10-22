import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> function = list -> {
            int min = list.stream().mapToInt(e -> e).min().getAsInt();
            return list.lastIndexOf(min);
        };

        System.out.println(function.apply(numbers));
    }
}
