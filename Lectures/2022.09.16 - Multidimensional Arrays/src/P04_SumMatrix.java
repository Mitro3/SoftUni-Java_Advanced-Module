import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] dimensions = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            matrix[i] = readArray(input);
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }

        System.out.println(sum);

    }

    private static int[] readArray(String input) {
        return Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
