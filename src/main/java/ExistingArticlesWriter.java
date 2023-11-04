import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExistingArticlesWriter {
    private static final String DOWNLOAD_DIRECTORY_SMALL = "Downloaded images - small";
    private static final String DOWNLOAD_DIRECTORY_BIG = "Downloaded images - big";

    public static void main(String[] args) {
        try {
            compareAndDeleteFiles();
            System.out.println("Files compared and deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compareAndDeleteFiles() throws IOException {
        File directorySmall = new File(DOWNLOAD_DIRECTORY_SMALL);
        File directoryBig = new File(DOWNLOAD_DIRECTORY_BIG);
        if (directorySmall.exists() && directorySmall.isDirectory() && directoryBig.exists() && directoryBig.isDirectory()) {
            File[] filesSmall = directorySmall.listFiles();
            File[] filesBig = directoryBig.listFiles();
            if (filesSmall != null && filesBig != null) {
                for (File fileSmall : filesSmall) {
                    String fileName = fileSmall.getName();
                    File matchingFileBig = new File(directoryBig, fileName);
                    if (!matchingFileBig.exists()) {
                        System.out.println("Deleting file: " + fileSmall.getAbsolutePath());
                        Files.delete(fileSmall.toPath());
                    }
                }
            }
        }
    }
}