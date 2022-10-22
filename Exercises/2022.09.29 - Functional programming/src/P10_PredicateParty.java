import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> guests = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commandData = input.split("\\s+");
            String command = commandData[0];
            String commandCriteria = commandData[1];
            String criteriaParameter = commandData[2];

            if (command.equals("Remove")) {
                guests.removeIf(getPredicate(commandCriteria, criteriaParameter)); // НЕ РАБОТИ
            } else if (command.equals("Double")) {
                for (int i = 0; i < guests.size(); i++) {
                    String currGuest = guests.get(i);
                    int currGuestIndex = guests.indexOf(currGuest);

                    if (getPredicate(commandCriteria, criteriaParameter).test(currGuest)) {
                        guests.add(currGuestIndex, currGuest);
                        i++;
                    }
                }
            }

            input = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.printf("%s are going to the party!", String.join(", ", guests));
        }
    }

    private static Predicate<String> getPredicate(String commandCriteria, String criteriaParameter) {

        switch (commandCriteria) {
            case "StartsWith":
                return s -> s.startsWith(criteriaParameter);

            case "EndsWith":
                return s -> s.endsWith(criteriaParameter);

            case "Length":
                return s -> s.length() == Integer.parseInt(criteriaParameter);
        }

        return null;
    }
}
