import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03_CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMinNumber = arr -> Collections.min(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        int minNumber = getMinNumber.apply(numbers);
        System.out.println(minNumber);
    }
}
