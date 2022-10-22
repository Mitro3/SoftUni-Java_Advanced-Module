package P09_CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Cat> cats = new HashMap<>();

        while (!input.equals("End")) {
            String[] catData = input.split("\\s+");
            String catBreed = catData[0];
            String catName = catData[1];
            Cat cat = null;

            switch (catBreed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(catName, earSize);
                    break;

                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(catName, furLength);
                    break;

                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(catName, decibelsOfMeows);
                    break;
            }
            cats.put(catName, cat);

            input = scanner.nextLine();
        }

        String catNameToSearch = scanner.nextLine();

        if (cats.containsKey(catNameToSearch)) {
            System.out.println(cats.get(catNameToSearch));
        }

    }
}
