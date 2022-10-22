import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        readMatrix(scanner, matrix);

        int primeDiagSum = 0;
        for (int index = 0; index < size; index++) {
            primeDiagSum += matrix[index][index];
        }

        int secondaryDiagSum = 0;
        for (int row = size - 1, col = 0; row >= 0; row--, col++) {
            secondaryDiagSum += matrix[row][col];
        }

        int sumDifference = Math.abs(primeDiagSum - secondaryDiagSum);
        System.out.println(sumDifference);
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            matrix[row] = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
