import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputData = input.split("\\s+");
        int rows = Integer.parseInt(inputData[0]);
        int cols = Integer.parseInt(inputData[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char outsideLetter = (char)('a' + row);
                char middleLetter = (char)('a' + row + col);
                matrix[row][col] = String.valueOf(outsideLetter) + middleLetter + outsideLetter;
            }
        }

        for (String[] strings : matrix) {
            for (String palindrome : strings) {
                System.out.print(palindrome + " ");
            }

            System.out.println();
        }
    }
}
