import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] sizes = input.split("\\s+");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        int[][] matrix = new int[rows][cols];
        readMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int maxSumStartRow = -1;
        int maxSumStartCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isInBounds(row, col, matrix)) {
//                    int currSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
//                            + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
//                            + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                    int currSum = 0;
                    for (int currRow = row; currRow < row + 3; currRow++) {
                        for (int currCol = col; currCol < col + 3; currCol++) {
                            currSum += matrix[currRow][currCol];
                        }
                    }

                    if (currSum > maxSum) {
                        maxSum = currSum;
                        maxSumStartRow = row;
                        maxSumStartCol = col;
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int row = maxSumStartRow; row < maxSumStartRow + 3; row++) {
            for (int col = maxSumStartCol; col < maxSumStartCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            matrix[row] = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row + 2 < matrix.length
                && col >= 0 && col + 2< matrix[row].length;
    }
}
