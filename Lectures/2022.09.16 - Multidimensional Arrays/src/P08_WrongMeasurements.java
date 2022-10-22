import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixLength = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixLength][];

        for (int i = 0; i < matrixLength; i++) {
            String input = scanner.nextLine();
            matrix[i] = readArray(input);
        }

        String input = scanner.nextLine();
        int[] indices = readArray(input);
        int valueToReplace = matrix[indices[0]][indices[1]];

        List<int[]> correctValues = new ArrayList<>();

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == valueToReplace) {
                    int correctValue = getNearbySum(matrix, rows, cols, valueToReplace);
                    correctValues.add(new int[]{rows, cols, correctValue});
                }
            }
        }

        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }

        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    private static int getNearbySum(int[][] matrix, int row, int col, int valueToReplace) {
        int sum = 0;

        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != valueToReplace) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != valueToReplace) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != valueToReplace) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != valueToReplace) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static int[] readArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return !isInBounds(row, col, matrix);
    }
}
