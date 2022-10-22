import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02_SumBytes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bufferedReader.readLine();

        long sum = 0;

        while (line != null) {
            char[] charsFromLine = line.toCharArray();
            for (char c : charsFromLine) {
                sum += c;
            }
            line = bufferedReader.readLine();
        }

        System.out.println(sum);
        bufferedReader.close();
    }
}
