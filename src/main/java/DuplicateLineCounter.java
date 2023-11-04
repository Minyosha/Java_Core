import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DuplicateLineCounter {
    private static final String FILE_PATH = "Articles.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Map<String, Integer> lineCountMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lineCountMap.put(line, lineCountMap.getOrDefault(line, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : lineCountMap.entrySet()) {
                String duplicateLine = entry.getKey();
                int count = entry.getValue();
                if (count >= 2) {
                    System.out.println("Line: " + duplicateLine + " is duplicated " + count + " times");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}