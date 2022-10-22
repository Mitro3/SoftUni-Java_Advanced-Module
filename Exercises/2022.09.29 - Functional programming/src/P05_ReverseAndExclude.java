import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> list = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int numberToDivide = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);

        list.removeIf(number -> number % numberToDivide == 0);

        list.forEach(e -> System.out.print(e + " "));
    }
}
