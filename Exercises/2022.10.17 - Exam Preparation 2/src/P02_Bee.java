import java.util.Scanner;

public class P02_Bee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];
        int beeRow = -1;
        int beeCol = -1;

        for (int i = 0; i < size; i++) {
            char[] currRow = scanner.nextLine().toCharArray();

            for (int j = 0; j < size; j++) {
                territory[i][j] = currRow[j];
                if (territory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }

        String command = scanner.nextLine();
        int flowers = 0;

        while (!command.equals("End")) {
            territory[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                territory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                flowers++;
            } else if (territory[beeRow][beeCol] == 'O') {
                continue;
            }

            territory[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        printTerritory(territory);
    }

    private static void printTerritory(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char currChar : chars) {
                System.out.print(currChar);
            }
            System.out.println();
        }
    }

}
