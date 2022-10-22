import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(", ");
        int size = Integer.parseInt(inputArr[0]);
        String pattern = inputArr[1];

        int[][] matrix = new int[size][size];

        switch (pattern) {
            case "A":
                readMatrixPatternA(matrix);
                break;
            case "B":
                readMatrixPatternB(matrix);
                break;
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void readMatrixPatternA(int[][] matrix) {
        int currNumber = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = currNumber;
                currNumber++;
            }
        }
    }

    public static void readMatrixPatternB(int[][] matrix) {
        int currNumber = 1;

        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = currNumber;
                    currNumber++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = currNumber;
                    currNumber++;
                }
            }
        }

    }
}
