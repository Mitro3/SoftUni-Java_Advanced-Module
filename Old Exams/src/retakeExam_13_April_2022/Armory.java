package retakeExam_13_April_2022;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[size][size];
        readMatrix(scanner, armory);

        int[] officerCoordinates = findOfficerPosition(armory);
        int officerRow = officerCoordinates[0];
        int officerCol = officerCoordinates[1];

        int[] firstMirrorCoordinates = findMirrorPosition(armory, 0, 0);
        int firstMirrorRow = -1;
        int firstMirrorCol = -1;
        int secondMirrorRow = -1;
        int secondMirrorCol = -1;

        if (firstMirrorCoordinates.length == 2) {
            firstMirrorRow = firstMirrorCoordinates[0];
            firstMirrorCol = firstMirrorCoordinates[1];
            int[] secondMirrorCoordinates = new int[2];

            if (firstMirrorCol != size - 1 && firstMirrorCol != -1) {
                secondMirrorCoordinates = findMirrorPosition(armory, firstMirrorRow, firstMirrorCol + 1);
            } else {
                secondMirrorCoordinates = findMirrorPosition(armory, firstMirrorRow + 1, 0);
            }

            secondMirrorRow = secondMirrorCoordinates[0];
            secondMirrorCol = secondMirrorCoordinates[1];
        }

        int coins = 0;
        boolean isOutsideArmory = false;

        while (coins < 65 && !isOutsideArmory) {
            String command = scanner.nextLine();
            int currRow = officerRow;
            int currCol = officerCol;

            if (command.equals("up") && officerRow - 1 >= 0) {
                officerRow--;
            } else if (command.equals("down") && officerRow + 1 < size) {
                officerRow++;
            } else if (command.equals("left") && officerCol - 1 >= 0) {
                officerCol--;
            } else if (command.equals("right") && officerCol + 1 < size) {
                officerCol++;
            } else {
                isOutsideArmory = true;
                armory[officerRow][officerCol] = '-';
                break;
            }

            armory[currRow][currCol] = '-';

            if (armory[officerRow][officerCol] == 'M') {
                if (armory[officerRow][officerCol + 1] != size - 1) {
                    currCol++;
                } else {
                    currRow++;
                }

                armory[officerRow][officerCol] = '-';

                if (isFirstMirror(armory, currRow, currCol)) {
                    officerRow = secondMirrorRow;
                    officerCol = secondMirrorCol;
                } else {
                    officerRow = firstMirrorRow;
                    officerCol = firstMirrorCol;
                }

                armory[officerRow][officerCol] = 'A';

            }

            int currSwordPrice = 0;
            if (Character.isDigit(armory[officerRow][officerCol])) {
                currSwordPrice = Integer.parseInt(armory[officerRow][officerCol] + "");
                coins += currSwordPrice;
            }

            armory[officerRow][officerCol] = 'A';

        }

        if (isOutsideArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", coins);
        for (char[] rows : armory) {
            for (char col : rows) {
                System.out.print(col);
            }
            System.out.println();
        }

    }

    private static boolean isFirstMirror(char[][] armory, int currRow, int currCol) {
        for (int r = currRow; r < armory.length; r++) {
            for (int c = currCol; c < armory.length; c++) {
                if (armory[r][c] == 'M') {
                    return true;
                }
            }
            currCol = 0;
        }

        return false;
    }

    private static void readMatrix(Scanner scanner, char[][] armory) {
        for (int r = 0; r < armory.length; r++) {
            armory[r] = scanner.nextLine().toCharArray();
        }
    }

    private static int[] findOfficerPosition(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'A') {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{0};
    }

    private static int[] findMirrorPosition(char[][] matrix, int startRow, int startCol) {
        for (int r = startRow; r < matrix.length; r++) {
            for (int c = startCol; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    return new int[]{r, c};
                }
            }
            startCol = 0;
        }

        return new int[]{-1, -1};
    }
}
