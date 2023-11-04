import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompareFiles {
    private static final String DOWNLOAD_DIRECTORY_SMALL = "Downloaded images - small";
    private static final String DOWNLOAD_DIRECTORY_BIG = "Downloaded images - big";
    private static final String COMPARE_FILE_PATH = "Compare.txt";

    public static void main(String[] args) {
        try {
            List<String> filesPresentInBig = getFilesPresentInBigAndAbsentInSmall();
            List<String> filesPresentInSmall = getFilesPresentInSmallAndAbsentInBig();

            writeCompareFile(filesPresentInBig, filesPresentInSmall);

            System.out.println("Comparison done successfully. Results written to Compare.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFilesPresentInBigAndAbsentInSmall() {
        List<String> filesPresentInBigAndAbsentInSmall = new ArrayList<>();

        File directorySmall = new File(DOWNLOAD_DIRECTORY_SMALL);
        File directoryBig = new File(DOWNLOAD_DIRECTORY_BIG);

        if (directorySmall.exists() && directorySmall.isDirectory() && directoryBig.exists() && directoryBig.isDirectory()) {
            File[] filesBig = directoryBig.listFiles();
            if (filesBig != null) {
                for (File fileBig : filesBig) {
                    String fileName = fileBig.getName();
                    File matchingFileSmall = new File(directorySmall, fileName);
                    if (!matchingFileSmall.exists()) {
                        filesPresentInBigAndAbsentInSmall.add(fileName);
                    }
                }
            }
        }

        return filesPresentInBigAndAbsentInSmall;
    }

    private static List<String> getFilesPresentInSmallAndAbsentInBig() {
        List<String> filesPresentInSmallAndAbsentInBig = new ArrayList<>();

        File directorySmall = new File(DOWNLOAD_DIRECTORY_SMALL);
        File directoryBig = new File(DOWNLOAD_DIRECTORY_BIG);

        if (directorySmall.exists() && directorySmall.isDirectory() && directoryBig.exists() && directoryBig.isDirectory()) {
            File[] filesSmall = directorySmall.listFiles();
            if (filesSmall != null) {
                for (File fileSmall : filesSmall) {
                    String fileName = fileSmall.getName();
                    File matchingFileBig = new File(directoryBig, fileName);
                    if (!matchingFileBig.exists()) {
                        filesPresentInSmallAndAbsentInBig.add(fileName);
                    }
                }
            }
        }

        return filesPresentInSmallAndAbsentInBig;
    }

    private static void writeCompareFile(List<String> filesPresentInBig, List<String> filesPresentInSmall) throws IOException {
        try (FileWriter writer = new FileWriter(COMPARE_FILE_PATH)) {
            writer.write("Files present in 'Downloaded images - big' and absent in 'Downloaded images - small':\n");
            for (String fileName : filesPresentInBig) {
                writer.write(fileName + "\n");
            }

            writer.write("\nFiles present in 'Downloaded images - small' and absent in 'Downloaded images - big':\n");
            for (String fileName : filesPresentInSmall) {
                writer.write(fileName + "\n");
            }
        }
    }
}