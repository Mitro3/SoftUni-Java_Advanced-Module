import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> names = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        Consumer<String> consumer = n -> System.out.println(n);

        names.forEach(consumer);

//        for (String name : names) {
//            consumer.accept(name);
//        }
    }
}
