import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06_GetFolderSize {

    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(new FileReader("resources/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split("\\s+");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String word : wordsToSearch) {
            map.put(word, 0);
        }

        wordScanner.close();

        Scanner fileScanner = new Scanner(new FileReader("resources/text.txt"));
        String singleWord = fileScanner.next();

        while (fileScanner.hasNext()) {
            if (map.containsKey(singleWord)) {
                int occurrences = map.get(singleWord);
                occurrences++;
                map.put(singleWord, occurrences);
            }

            singleWord = fileScanner.next();
        }

        fileScanner.close();

        PrintWriter pw = new PrintWriter(new FileWriter("resources/results.txt"));
        map.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
                .forEach(e -> pw.printf("%s - %s%n", e.getKey(), e.getValue()));
        pw.close();
    }
}
