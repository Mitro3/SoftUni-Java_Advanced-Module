import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01_SumLines {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bufferedReader.readLine();

        while (line != null) {
            long sum = 0;
            char[] charsFromLine = line.toCharArray();
            for (char c : charsFromLine) {
                sum += c;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
