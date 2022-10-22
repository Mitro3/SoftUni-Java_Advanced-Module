package exam_19_February_2022;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];
        readMatrix(scanner, chessboard.length, chessboard);
        int[] findWhitePawnCoordinates = getPawnPosition(chessboard, 'w');
        int whitePawnRow = findWhitePawnCoordinates[0];
        int whitePawnCol = findWhitePawnCoordinates[1];
        int[] findBlackPawnCoordinates = getPawnPosition(chessboard, 'b');
        int blackPawnRow = findBlackPawnCoordinates[0];
        int blackPawnCol = findBlackPawnCoordinates[1];

        boolean isCaptured = false;

        while (whitePawnRow != 0 && blackPawnRow != 7 && !isCaptured) {

            if (checkWhiteWinningPosition(whitePawnRow, whitePawnCol, blackPawnRow, blackPawnCol)
                    && whitePawnRow - 1 != 0) {
                System.out.printf("Game over! White capture on %s.", findCoordinates(blackPawnCol, blackPawnRow));
                isCaptured = true;
            }

            whitePawnRow--;

            if (whitePawnRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.", findCoordinates(whitePawnCol, whitePawnRow));
                break;
            }

            if (checkBlackWinningPosition(whitePawnRow, whitePawnCol, blackPawnRow, blackPawnCol)) {
                System.out.printf("Game over! Black capture on %s.", findCoordinates(whitePawnCol, whitePawnRow));
                isCaptured = true;
            }

            blackPawnRow++;

            if (blackPawnRow == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.", findCoordinates(blackPawnCol, blackPawnRow));
                break;
            }
        }
    }

    private static void readMatrix(Scanner scanner, int size, char[][] field) {
        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }

    private static int[] getPawnPosition(char[][] matrix, char pawn) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == pawn) {
                    return new int[]{r, c};
                }
            }
        }

        return new int[]{-1};
    }

    private static boolean checkWhiteWinningPosition(int whitePawnRow, int whitePawnCol, int blackPawnRow, int blackPawnCol) {
        return whitePawnRow - 1 == blackPawnRow && (blackPawnCol == whitePawnCol - 1 || blackPawnCol == whitePawnCol + 1);
    }

    private static boolean checkBlackWinningPosition(int whitePawnRow, int whitePawnCol, int blackPawnRow, int blackPawnCol) {
        return blackPawnRow + 1 == whitePawnRow && (whitePawnCol == blackPawnCol - 1 || whitePawnCol == blackPawnCol + 1);
    }

    private static String findCoordinates(int c, int r) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[c]).append(row[r]);
        return sb.toString();
    }
}
