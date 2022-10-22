import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        String rotationNumberString = rotation.split("[()]")[1];
        int rotationNumber = Integer.parseInt(rotationNumberString);
        int angleOfRotation = rotationNumber % 360;

        List<String> wordsList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            wordsList.add(input);

            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }

        int rows = wordsList.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];
        readMatrix(wordsList, matrix);

        switch (angleOfRotation) {
            case 0:
                for (char[] row : matrix) {
                    for (char element : row) {
                        System.out.print(element);
                    }
                    System.out.println();
                }
                break;
                
            case 90:
                for (int col = 0; col < cols ; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
                
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
                
            case 270:
                for (int col = cols - 1; col >= 0 ; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void readMatrix(List<String> list, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String currWord = list.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < currWord.length()) {
                    matrix[row][col] = currWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
