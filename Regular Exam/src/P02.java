import java.util.Scanner;

public class P02 {
    public static int carRow;
    public static int carCol;
    public static int kmPassed;
    public static boolean isFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] track  = new char[size][size];
        readMatrix(scanner, track);

        String command = scanner.nextLine();
        while (!command.equals("End") && !isFinish) {

            switch (command) {
                case "up":
                    moveCar(track, - 1, 0);
                    break;

                case "down":
                    moveCar(track, + 1, 0);
                    break;

                case "left":
                    moveCar(track, 0, - 1);
                    break;

                case "right":
                    moveCar(track, 0, + 1);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(isFinish ? "Racing car " + racingNumber + " finished the stage!"
                : "Racing car " + racingNumber + " DNF.");
        System.out.printf("Distance covered %d km.%n", kmPassed);

        track[carRow][carCol] = 'C';

        for (char[] chars : track) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    private static void readMatrix(Scanner scanner, char[][] field) {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
    }

    private static void moveCar(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = carRow + rowMutator;
        int nextCol = carCol + colMutator;

        if (matrix[nextRow][nextCol] == 'T') {
            int[] nextTunnelCoordinates = new int[2];
            if (nextCol != matrix.length - 1) {
                nextTunnelCoordinates = findNexTunnel(matrix, nextRow, nextCol + 1);
            } else {
                nextTunnelCoordinates = findNexTunnel(matrix, nextRow + 1, nextCol);
            }

            int nextTunnelRow = nextTunnelCoordinates[0];
            int nextTunnelCol = nextTunnelCoordinates[1];
            matrix[nextRow][nextCol] = '.';
            carRow = nextTunnelRow;
            carCol = nextTunnelCol;
            matrix[carRow][carCol] = '.';
            kmPassed += 30;
            return;
        } else if (matrix[nextRow][nextCol] == 'F') {
            kmPassed += 10;
            isFinish = true;
        } else {
            kmPassed += 10;
        }

        carRow = nextRow;
        carCol = nextCol;
    }

    public static int[] findNexTunnel(char[][] matrix, int startRow, int startCol){
        for (int r = startRow; r < matrix.length; r++) {
            for (int c = startCol; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'T') {
                    return new int[]{r, c};
                }
            }
            startCol = 0;
        }

        return new int[]{-1, -1};
    }
}
