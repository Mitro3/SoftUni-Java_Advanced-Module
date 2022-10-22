package retakeExam_18_August_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rowsSize = Integer.parseInt(input[0]);
        int colsSize = Integer.parseInt(input[1]);

        char[][] field = new char[rowsSize][colsSize];


        readMatrix(scanner, rowsSize, colsSize, field);

        int[] playerStartPosition = getPlayerPosition(field);
        int playerRow = playerStartPosition[0];
        int playerCol = playerStartPosition[1];

        int currRowPosition = -1;
        int currColPosition = -1;
        List<String> path = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            currRowPosition = playerRow;
            currColPosition = playerCol;

            if (command.equals("up") && playerRow != 0) {
                playerRow--;
            } else if (command.equals("down") && playerRow != rowsSize - 1) {
                playerRow++;
            } else if (command.equals("right") && playerCol != colsSize - 1) {
                playerCol++;
            } else if (command.equals("left") && playerCol != 0) {
                playerCol--;
            } else {
                command = scanner.nextLine();
                continue;
            }

            field[currRowPosition][currColPosition] = '-';

            if (field[playerRow][playerCol] == 'T') {
                playerRow = currRowPosition;
                playerCol = currColPosition;
                command = scanner.nextLine();
                continue;
            }

            path.add(command);
            command = scanner.nextLine();
        }

        if (field[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void readMatrix(Scanner scanner, int rowsSize, int colsSize, char[][] field) {
        for (int i = 0; i < rowsSize; i++) {
            String[] currRowData = scanner.nextLine().split("\\s+");
            char[] currRow = new char[colsSize];

            for (int ch = 0; ch < colsSize; ch++) {
                currRow[ch] = currRowData[ch].charAt(0);
            }

            for (int j = 0; j < colsSize; j++) {
                field[i][j] = currRow[j];
            }
        }
    }

    public static int[] getPlayerPosition(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'Y') {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1};
    }

}
