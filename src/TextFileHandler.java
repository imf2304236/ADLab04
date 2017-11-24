import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * <pre>
 * ADL Lab 04
 * Ian Fennie: 2304236
 * 21.10.17
 *
 * Project file compiled with Javac using JetBrains IntelliJ IDEA 2017.2.5
 * </pre>
 *
 * An implementation of a Text File Handler which allows a user to read
 * a number of lines of text from a text file and parse them into various
 * various data types.
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

    /**
     * Read lines of a text file and store as integers in an array
     * @param sourceFile String of pathname of text file to read
     * @param N Number of lines to be read
     * @return Array of integers read from file
     */
    public static Integer[] readIntegersFromFile(String sourceFile, int N) {
        Integer[] a = new Integer[N];
        BufferedReader reader = null;

        try {
            Path filePath = Paths.get(sourceFile).toAbsolutePath();
            reader = new BufferedReader(new FileReader(filePath.toString()));
            String line;
            line = reader.readLine();
            int i = 0;

            while(line != null) {
                a[i] = Integer.parseInt(line);
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

    public static PQmin.Pair[] readPairsFromFile(String sourceFile, int N, int lineNum) {
        PQmin.Pair[] a = new PQmin.Pair[N];
        BufferedReader reader = null;

        try {
            Path filePath = Paths.get(sourceFile).toAbsolutePath();
            reader = new BufferedReader(new FileReader(filePath.toString()));
            String line = reader.readLine();
            for (int i = 1; i <= lineNum; i++) {
                line = reader.readLine(); // Skip first line
            }

            int i = 0;
            while(i < N) {
                a[i] = new PQmin.Pair(null, null);
                String[] s = line.split("\\s{2,}");
                s[0] = s[0].trim().replace(",", ".");


                for (int j = 0; j < s.length; j++) {
                    if (j == 0) {

                        try {
                            a[i].setValue(Double.parseDouble(s[j]));
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    } else {
                        a[i].setKey(s[j]);
                    }
                }

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
}
