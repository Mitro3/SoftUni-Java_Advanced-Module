import java.util.*;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] tokens = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(tokens).forEach(e -> stack.push(e));

        ArrayDeque<String> reversedStack = new ArrayDeque<>();

        for (String e : stack) {
            String currElement = stack.pop();
            reversedStack.push(currElement);
        }
        while (reversedStack.size() > 1) {
            int firstNumber = Integer.parseInt(reversedStack.pop());
            String currOperator = reversedStack.pop();
            int secondNumber = Integer.parseInt(reversedStack.pop());

            switch (currOperator) {
                case "+":
                    reversedStack.push(String.valueOf(firstNumber + secondNumber));
                    break;

                case "-":
                    reversedStack.push(String.valueOf(firstNumber - secondNumber));
                    break;
            }
        }

        System.out.println(reversedStack.pop());
    }
}
