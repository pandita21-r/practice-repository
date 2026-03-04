import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private ReadFile() {
        // Preven instantation
    }

    public static void read(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Cannot read null or empty file.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((fileName = reader.readLine()) != null) {
                System.out.println(fileName);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
