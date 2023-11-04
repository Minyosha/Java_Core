import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArticleParser {
    private static final String ORIGINAL_FILE_PATH = "Articles original.txt";
    private static final String OUTPUT_FILE_PATH = "Articles.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ORIGINAL_FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Extract the number at the start of the line
                String number = extractNumber(line);

                // Write the number to the output file
                writer.write(number);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractNumber(String line) {
        // Split the line by whitespace and return the first element
        return line.trim().split("\\s+")[0];
    }
}