import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P05_Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] inputData = input.split("-");
            String name = inputData[0];
            String number = inputData[1];

           phonebook.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
