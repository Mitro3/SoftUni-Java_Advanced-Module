import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P05_LineNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter("resources/output.txt");

        String line = bf.readLine();
        int counter = 1;

        while (line != null) {
            pw.println(counter + ". " + line);
            counter++;
            line = bf.readLine();
        }

        bf.close();
        pw.close();
    }
}
