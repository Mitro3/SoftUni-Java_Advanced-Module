import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operationsCount = Integer.parseInt(scanner.nextLine());

        StringBuilder currString = new StringBuilder();

        ArrayDeque<String> stateStack = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    String stringToAppend = input[1];
                    stateStack.push(currString.toString());
                    currString.append(stringToAppend);
                    break;

                case "2":
                    int countErases = Integer.parseInt(input[1]);
                    stateStack.push(currString.toString());
                    currString.delete(currString.length() - countErases, currString.length());
                    break;

                case "3":
                    int indexToReturn = Integer.parseInt(input[1]);
                    System.out.println(currString.toString().charAt(indexToReturn - 1));
                    break;

                case "4":
                    currString = new StringBuilder(stateStack.pop());
                    break;
            }
        }

    }
}
