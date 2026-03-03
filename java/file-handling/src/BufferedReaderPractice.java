import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderPractice {
    public static void main(String[] args) {

        int[] numbers = { 1, 2, 3, 4 };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("practice.txt"))) {
            writer.write("The numbers are:");
            writer.newLine();
            for (int i = 0; i < numbers.length; i++) {
                writer.write(String.format("%d", numbers[i]));
                writer.newLine();
            }
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
