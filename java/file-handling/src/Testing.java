import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) {

        String[] foods = { "Hotdog", "Pizza", "Fries" };
        File file = new File("file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured" + e.getMessage());
        }

        try (FileWriter writer = new FileWriter(file)) {
            for (String line : foods) {
                writer.write(line + "\n");
            }
            System.out.println("Successfully write to " + file.getName());
        } catch (IOException e) {
            System.out.println("An error occured" + e.getMessage());
        }
        try (FileReader reader = new FileReader(file)) {
            BufferedReader rd = new BufferedReader(reader);
            String line;
            while ((line = rd.readLine()) != null) {
                if (line.matches("[Fries]+")) {
                    System.out.println("It works!");
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occured" + e.getMessage());
        }
    }
}
