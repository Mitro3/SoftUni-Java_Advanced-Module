import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_TheParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String currFilter = commandParts[0];
            String currFilterType = commandParts[1];
            String currParameter = commandParts[2];

            if (currFilter.equals("Add filter")) {
                filters.add(currFilterType + ";" + currParameter);
            } else {
                filters.remove(currFilterType + ";" + currParameter);
            }

            command = scanner.nextLine();
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        guests.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String parameter = filterParts[1];

        switch (filterType) {
            case "StartsWith":
                return s -> s.startsWith(parameter);

            case "EndsWith":
                return s -> s.endsWith(parameter);

            case "Length:":
                return s -> s.length() == Integer.parseInt(parameter);

            case "Contains":
                return s -> s.contains(parameter);
        }

        return null;
    }
}
