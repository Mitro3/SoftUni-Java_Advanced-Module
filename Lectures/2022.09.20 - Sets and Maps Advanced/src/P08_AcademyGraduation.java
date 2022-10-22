import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08_AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentsGrades = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double grade = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0);

            studentsGrades.putIfAbsent(name, grade);
        }

        DecimalFormat format = new DecimalFormat("0.#");
        studentsGrades.forEach((name, grade) -> System.out.printf("%s is graduated with %s%n", name, format.format(grade)));

    }
}
