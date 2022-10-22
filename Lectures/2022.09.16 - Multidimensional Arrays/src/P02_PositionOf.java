import java.util.Arrays;
import java.util.Scanner;

public class P02_PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] dimensions = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            matrix[i] = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int searchNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currNumber = matrix[row][col];

                if(currNumber == searchNumber){
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if(!isFound) {
            System.out.println("not found");
        }
    }
}
