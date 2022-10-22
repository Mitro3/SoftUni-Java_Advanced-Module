package exam_15_December_2021;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];
        readField(scanner, field, size);

        int[] parisCoordinates = findCoordinates(field, 'P');
        int parisRow = parisCoordinates[0];
        int parisCol = parisCoordinates[1];

        int[] helenCoordinates = findCoordinates(field, 'H');
        int helenRow = helenCoordinates[0];
        int helenCol = helenCoordinates[1];

        boolean isHelenFound = false;

        while (energy > 0) {
            String[] movementData = scanner.nextLine().split("\\s+");
            String direction = movementData[0];
            int spawnRow = Integer.parseInt(movementData[1]);
            int spawnCol = Integer.parseInt(movementData[2]);
            field[spawnRow][spawnCol] = 'S';
            field[parisRow][parisCol] = '-';

            if (direction.equals("up") && isInsideField(parisRow - 1, size)) {
                parisRow--;
            } else if (direction.equals("down") && isInsideField(parisRow + 1, size)) {
                parisRow++;
            } else if (direction.equals("left") && isInsideField(parisCol - 1, size)) {
                parisCol--;
            } else if (direction.equals("right") && isInsideField(parisCol + 1, size)) {
                parisCol++;
            }

            energy--;

            if (isSpartanFound(field, parisRow, parisCol)) {
                energy -= 2;

                if (energy <= 0) {
                    field[parisRow][parisCol] = 'X';
                    break;
                }
            }

            if (parisRow == helenRow && parisCol == helenCol) {
                isHelenFound = true;
                field[parisRow][parisCol] = '-';
                break;
            }

            if (energy <= 0) {
                field[parisRow][parisCol] = 'X';
                break;
            }

            field[parisRow][parisCol] = 'P';

        }

        if (energy <= 0 && !isHelenFound) {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        for (char[] chars : field) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    private static void readField(Scanner scanner, char[][] field, int size) {
        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().toCharArray();
        }
    }

    private static boolean isInsideField(int index, int size) {
        return index >= 0 && index < size;
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

    private static boolean isSpartanFound(char[][] matrix, int r, int c) {
        return matrix[r][c] == 'S';
    }

}
