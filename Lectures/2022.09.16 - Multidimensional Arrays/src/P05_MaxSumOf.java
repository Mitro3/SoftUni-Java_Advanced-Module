import java.util.Arrays;
import java.util.Scanner;

public class P05_MaxSumOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] dimensions = Arrays.stream(input.split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            matrix[i] = Arrays.stream(input.split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currSum > maxSum) {
                    maxSum = currSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1]);
        System.out.println(maxSum);
    }
}
