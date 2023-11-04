import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class MissingImageChecker {
    private static final String ARTICLES_FILE_PATH = "Articles.txt";
    private static final String IMAGES_FOLDER_PATH = "Downloaded images - small";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARTICLES_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int articleNumber = Integer.parseInt(line);
                String imagePath = IMAGES_FOLDER_PATH + File.separator + articleNumber + ".jpg";
                File imageFile = new File(imagePath);
                if (!imageFile.exists()) {
                    System.out.println("Missing image for article number: " + articleNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}