package retakeExam_18_August_2021;

import java.util.Scanner;

public class FormulaOne {
    public static int playerRow;
    public static int playerCol;
    public static boolean isFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] field  = new char[size][size];
        readMatrix(field, scanner);

        int[] playerCoordinates = findCoordinates(field, 'P');
        playerRow = playerCoordinates[0];
        playerCol = playerCoordinates[1];

        while (commandsCount-- > 0 && !isFinish) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    movePlayer(field, - 1, 0);
                    break;

                case "down":
                    movePlayer(field, + 1, 0);
                    break;

                case "left":
                    movePlayer(field, 0, - 1);
                    break;

                case "right":
                    movePlayer(field, 0, + 1);
                    break;
            }
        }

        System.out.println(isFinish ? "Well done, the player won first place!"
                : "Oh no, the player got lost on the track!");

        printMatrix(field);

    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
            }
        }

        if (matrix[nextRow][nextCol] == 'T') {
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {
            matrix[playerRow][playerCol] = '.';
            playerRow = nextRow;
            playerCol = nextCol;
            movePlayer(matrix, rowMutator, colMutator);
            return;
        } else if (matrix[nextRow][nextCol] == 'F') {
            isFinish = true;
        }
        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '.';
        }

        matrix[nextRow][nextCol] = 'P';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static void readMatrix(char[][] field, Scanner scanner) {
        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().toCharArray();
        }
    }

    private static int[] findCoordinates(char[][] matrix, char symbol) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1};
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
