import java.util.Scanner;

public class P07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = readArray(scanner);
        boolean isValidQueen = false;
        int validRow = -1;
        int validCol = -1;

        for (int row = 0; row < chessboard.length; row++) {
            for (int col = 0; col < chessboard[row].length; col++) {
                char currChar = chessboard[row][col].charAt(0);
                if (currChar == 'q') {
                    boolean notFoundAnotherQueen = !(foundQueenRight(row, col + 1, chessboard) || foundQueenLeft(row, col - 1, chessboard)
                            || foundQueenUp(row - 1, col, chessboard) || foundQueenDown(row + 1, col, chessboard)
                            || foundQueenDiagonalUpLeft(row - 1, col - 1, chessboard)
                            || foundQueenDiagonalDownLeft(row + 1, col - 1, chessboard)
                            || foundQueenDiagonalUpRight(row - 1, col + 1, chessboard)
                            || foundQueenDiagonalDownRight(row + 1, col + 1, chessboard));
                    if (notFoundAnotherQueen) {
                        isValidQueen = true;
                        validRow = row;
                        validCol = col;
                        break;
                    }
                }
            }
            if (isValidQueen) {
                break;
            }
        }

        System.out.println(validRow + " " + validCol);
    }

    public static boolean foundQueenDiagonalUpLeft(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row--;
            col--;
        }

        return false;
    }

    public static boolean foundQueenDiagonalDownLeft(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row++;
            col--;
        }

        return false;
    }

    public static boolean foundQueenDiagonalDownRight(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row++;
            col++;
        }

        return false;
    }

    public static boolean foundQueenDiagonalUpRight(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row--;
            col++;
        }

        return false;
    }

    public static boolean foundQueenRight(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            col++;
        }

        return false;
    }

    public static boolean foundQueenLeft(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            col--;
        }

        return false;
    }

    public static boolean foundQueenUp(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row--;
        }

        return false;
    }

    public static boolean foundQueenDown(int row, int col, String[][] matrix) {
        while (isIndexInBounds(row, col, matrix)) {
            char currChar = matrix[row][col].charAt(0);
            if (currChar == 'q') {
                return true;
            }
            row++;
        }

        return false;
    }

    public static String[][] readArray(Scanner scanner) {
        String[][] array = new String[8][8];

        for (int i = 0; i < array.length; i++) {
            String input = scanner.nextLine();
            array[i] = input.split("\\s+");
        }
        return array;
    }

    public static boolean isIndexInBounds(int row, int col, String[][] matrix) {
        return row > 0 && row < matrix.length
                && col > 0 && col < matrix[row].length;
    }
}
