package exam_23_October_2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field  = new char[size][size];
        readMatrix(field, scanner);

        int[] mouseCoordinates = findMouseCoordinates(field);
        int mouseRow = mouseCoordinates[0];
        int mouseCol = mouseCoordinates[1];

        int cheeseCount = 0;
        boolean isLost = false;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            field[mouseRow][mouseCol] = '-';

            if (command.equals("up") && isInBounds(mouseRow - 1, size)) {
                mouseRow--;
            } else if (command.equals("down") && isInBounds(mouseRow + 1, size)) {
                mouseRow++;
            } else if (command.equals("left") && isInBounds(mouseCol - 1, size)) {
                mouseCol--;
            } else if (command.equals("right") && isInBounds(mouseCol + 1, size)) {
                mouseCol++;
            } else {
                isLost = true;
                break;
            }

            if (field[mouseRow][mouseCol] == 'B') {
                field[mouseRow][mouseCol] = 'M';
                continue;
            }

            if (field[mouseRow][mouseCol] == 'c') {
                cheeseCount++;
            }

            field[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }

        if (isLost) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseCount < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCount);
        }

        for (char[] chars : field) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void readMatrix(char[][] field, Scanner scanner) {
        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().toCharArray();
        }
    }

    private static int[] findMouseCoordinates(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1};
    }

    private static boolean isInBounds(int index, int size) {
        return index >= 0 && index < size;
    }
}
