import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ADLab03
 * Created by IF on 08.11.17.
 */
public class TextFileHandler {
    /**
     * File reading method to read 1024 lines of a text file and store in an array
     * @param sourceFile String of pathname of text file to read
     * @return Array of strings of each line of the text file
     */
    public static String[] readFromFile(String sourceFile) {
        String[] a = new String[1024];
        BufferedReader reader = null;

        try {
            Path filePath = Paths.get(sourceFile).toAbsolutePath();
            reader = new BufferedReader(new FileReader(filePath.toString()));
            String line;
            line = reader.readLine();
            int i = 0;

            while(line != null) {
                a[i] = line;
                line = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e){
                    System.err.println(e);
                }
            }
        }
        return a;
    }

    /**
     * Read lines of a text file and store strings in an array
     * @param sourceFile String of pathname of text file to read
     * @param N Number of lines to be read
     * @return Array of strings read from file
     */
    public static String[] readStringsFromFile(String sourceFile, int N) {
        String[] a = new String[N];
        BufferedReader reader = null;

        try {
            Path filePath = Paths.get(sourceFile).toAbsolutePath();
            reader = new BufferedReader(new FileReader(filePath.toString()));
            String line;
            line = reader.readLine();
            int i = 0;

            while(line != null) {
                a[i] = line;
                line = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e){
                    System.err.println(e);
                }
            }
        }
        return a;
    }

    /*
    public static void writeToFile() {
        try {
            Path filePath = Paths.get(FILE).toAbsolutePath();
            FileWriter writer = new FileWriter(filePath.toString());
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    */
}
