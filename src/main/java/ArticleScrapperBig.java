import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleScrapperBig {
    private static final String ARTICLE_FILE_PATH = "Existing articles.txt";
    private static final String DOWNLOAD_DIRECTORY = "Downloaded images - big";

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            // Read article numbers from the file
            int[] articleNumbers = readArticleNumbersFromFile();

            // Process each article number
            for (int articleNumber : articleNumbers) {
                // Generate the link
                System.out.println(articleNumber);
                String link = generateLink(articleNumber);

                // Load the page and parse the first link
                String firstLink = parseFirstLink(link);

                // Open the first link and parse the image link
                String imageLink = parseImageLink(firstLink);
                if (imageLink != null) {
                    // Download the image
                    downloadImage(imageLink, articleNumber);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");
    }

    private static int[] readArticleNumbersFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARTICLE_FILE_PATH))) {
            return reader.lines()
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static String generateLink(int articleNumber) {
        return "https://chint.ru/catalog/?q=" + articleNumber;
    }

    private static String parseFirstLink(String link) throws IOException {
        URL url = new URL(link);
        try (Scanner scanner = new Scanner(url.openStream())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("<a onclick=\"return true\" href=\"")) {
                    Pattern pattern = Pattern.compile("href=\"(.*?)\"");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        return "https://chint.ru" + matcher.group(1);
                    }
                }
            }
        }
        throw new IOException("No first link found");
    }

    private static String parseImageLink(String link) {
        try {
            URL url = new URL(link);
            try (Scanner scanner = new Scanner(url.openStream())) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains("<a href=\"/upload/iblock") && !line.contains("<li><a href=\"/upload/iblock")) {
                        Pattern pattern = Pattern.compile("<a href=\"(.*?\\.jpg)\"");
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            return "https://chint.ru" + matcher.group(1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Return null if image link cannot be parsed
    }

    private static void downloadImage(String imageLink, int articleNumber) throws IOException {

        URL url = new URL(imageLink);
        Path directoryPath = Path.of(DOWNLOAD_DIRECTORY);
        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);
        }
        String fileName = articleNumber + ".jpg";
        Path filePath = directoryPath.resolve(fileName);
        Files.copy(url.openStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }
}