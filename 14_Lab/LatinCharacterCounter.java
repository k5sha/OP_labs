import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LatinCharacterCounter {
    
    public static long numberOfLatinCharacters(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty.");
        }

        long count = 0;

        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    char c = (char) buffer[i];
                    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    //    In args and in root directory not in src, example of args: ./test1.txt
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java LatinCharacterCounter <filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            long count = numberOfLatinCharacters(filename);
            System.out.println("Number of Latin characters in the file: " + count);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred - " + e.getMessage());
        }
    }
}
