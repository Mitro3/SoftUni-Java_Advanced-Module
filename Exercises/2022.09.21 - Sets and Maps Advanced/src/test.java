import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = new int[8];
        int[] secondArr = new int[6];
        readArray(scanner, firstArr);
        readArray(scanner, secondArr);

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        System.out.println();
    }

    private static void readArray(Scanner scanner, int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }

    }
}
