import java.io.*;
import java.util.Locale;

public class P03_AllCapitals {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));

        bufferedReader.lines().forEach(line -> pw.println(line.toUpperCase()));
        bufferedReader.close();
        pw.close();
    }
}
