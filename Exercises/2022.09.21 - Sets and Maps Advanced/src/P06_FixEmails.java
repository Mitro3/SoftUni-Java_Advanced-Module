import java.util.*;

public class P06_FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
