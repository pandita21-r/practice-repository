import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderPractice {
    public static void main(String[] args) {

        String[] names = { "Mark", "Jamal", "Ken" };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("practice.txt"))){
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
                System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
