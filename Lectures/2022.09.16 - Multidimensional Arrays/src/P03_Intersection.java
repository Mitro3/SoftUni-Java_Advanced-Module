import java.util.Arrays;
import java.util.Scanner;

public class P03_Intersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        char[][] resultMatrix = new char[rows][cols];

        readMatrix(scanner, firstMatrix);
        readMatrix(scanner, secondMatrix);

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    resultMatrix[i][j] = firstMatrix[i][j];
                } else {
                    resultMatrix[i][j] = '*';
                }
            }
        }

        for (char[] matrix : resultMatrix) {
            for (char c : matrix) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    private static void readMatrix(Scanner scanner, char[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = readArray(scanner);
        }
    }

    private static char[] readArray(Scanner scanner) {
        String[] inputArr = scanner.nextLine().split("\\s+");
        char[] charArray = new char[inputArr.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = inputArr[i].charAt(0);
        }

        return charArray;
    }

}
