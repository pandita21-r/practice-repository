public class Main {
    public static void main(String[] args) {

        String[] data = { "Cat", "Dog", "Bird", "Fish" };

        WriteToFile.write("data.txt", data);
        ReadFile.read("data.txt");
        System.out.println("Data successfully stored.");
    }
}
