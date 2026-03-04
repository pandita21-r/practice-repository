import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void Write(String[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null or blank.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (int i = 0; i < data.length; i++) {
                writer.write(String.format("%s", data[i]));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}