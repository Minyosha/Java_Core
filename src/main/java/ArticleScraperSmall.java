import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArticleScraperSmall {
    private static final String DOWNLOAD_DIRECTORY = "Downloaded images - small";

    public static void main(String[] args) {
        try {
            // Read article numbers from the text file
            Scanner scanner = new Scanner(Paths.get("articles.txt"));
            while (scanner.hasNextLine()) {
                String articleNumber = scanner.nextLine().trim();
                String url = "https://chint.ru/catalog/?q=" + articleNumber;

                // Load the page
                Connection.Response response = Jsoup.connect(url).execute();
                String contentType = response.contentType();

                // Check if the content type is suitable for parsing
                if (contentType != null && (contentType.startsWith("text/") || contentType.contains("xml"))) {
                    Document document = response.parse();

                    // Find the image element
                    Element imageDiv = document.selectFirst("div.image");
                    if (imageDiv != null) {
                        Element imageElement = imageDiv.selectFirst("img");
                        if (imageElement != null) {
                            String imageUrl = imageElement.absUrl("src");

                            // Download the image
                            downloadImage(imageUrl, DOWNLOAD_DIRECTORY + File.separator + articleNumber + ".jpg");
                        }
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadImage(String imageUrl, String fileName) throws IOException {
        URL url = new URL(imageUrl);
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream out = new FileOutputStream(fileName);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        out.close();
        in.close();
    }
}