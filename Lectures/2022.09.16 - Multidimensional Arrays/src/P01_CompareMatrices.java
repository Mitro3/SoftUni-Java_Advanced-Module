import java.util.Arrays;
import java.util.Scanner;

public class P01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int col = Integer.parseInt(input.split("\\s+")[1]);

        int[][] first = readArray(rows, col, scanner);

        rows = scanner.nextInt();
        col = scanner.nextInt();
        int[][] second = readArray(rows, col, scanner);

        System.out.println();

        boolean notEqual = isNotEqual(rows, col, first, second);

        if (notEqual) {
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }
    }

    private static boolean isNotEqual(int rows, int col, int[][] first, int[][] second) {
        if (first.length != second.length) {
            return true;
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < col; j++) {
                    if (first[i][j] != second[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[][] readArray(int arraysCount, int sizeOfArrays, Scanner scanner) {
        int[][] array = new int[arraysCount][sizeOfArrays];

        for (int rows = 0; rows < arraysCount; rows++) {
            for (int col = 0; col < sizeOfArrays; col++) {
                array[rows][col] = scanner.nextInt();
            }
        }

        return array;
    }
}
