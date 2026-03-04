import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

        // Utility class
        
public class WriteToFile {
    private WriteToFile() {
        // Prevent instantiation
    }

    public static void write(String fileName, String[] data) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be null or blank.");
        }
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data cannot be null or empty.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // Add "true" for append mode
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}