package exam_25_June_2022;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        String[] commands = scanner.nextLine().split(",");

        readMatrix(scanner, size, field);

        int[] playerPosition = getPlayerPosition(field);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        int totalMoneyStolen = 0;
        boolean isInJail = false;

        for (int i = 0; i < commands.length; i++) {
            String currCommand = commands[i];
            int currRow = playerRow;
            int currCol = playerCol;

            if (currCommand.equals("up") && playerRow - 1 >= 0) {
                playerRow--;
            } else if (currCommand.equals("down") && playerRow + 1 < size) {
                playerRow++;
            } else if (currCommand.equals("left") && playerCol - 1 >= 0) {
                playerCol--;
            } else if (currCommand.equals("right") && playerCol + 1 < size) {
                playerCol++;
            } else {
                printErrorMessage();
                continue;
            }

            field[currRow][currCol] = '+';

            if (field[playerRow][playerCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoneyStolen);
                field[playerRow][playerCol] = '#';
                isInJail = true;
                break;

            } else if (field[playerRow][playerCol] == '$') {
                int loot = playerRow * playerCol;
                totalMoneyStolen += loot;
                field[playerRow][playerCol] = '+';
                System.out.printf("You successfully stole %d$.%n", loot);

            }

            field[playerRow][playerCol] = 'D';

        }

        if (!isInJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoneyStolen);
        }

        for (char[] chars : field) {
            for (char currCh : chars) {
                System.out.print(currCh + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }

    private static int[] getPlayerPosition(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'D') {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1};
    }

    private static void printErrorMessage() {
        System.out.println("You cannot leave the town, there is police outside!");
    }
}
