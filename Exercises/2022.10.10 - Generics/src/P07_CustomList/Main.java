package P07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Add":
                    String elementToAdd = input.split("\\s+")[1];
                    customList.add(elementToAdd);
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(input.split("\\s+")[1]);
                    customList.remove(indexToRemove);
                    break;

                case "Contains":
                    String elementToSearch = input.split("\\s+")[1];
                    System.out.println(customList.contains(elementToSearch));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;

                case "Greater":
                    String element = input.split("\\s+")[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    System.out.println(customList);
                    break;
            }

            input = scanner.nextLine();
        }

    }
}
