
public class Main {
    public static void main(String[] args) {

         String[] data = { "Cat", "Dog", "Bird", "Fish" };
         WriteToFile.write("data.txt", data);
         ReadFile.read("data.txt");
         System.out.println("Data successfully stored.");

        // ArrayList<String> list = new ArrayList<>();

        // list.add("Tomato");
        // list.add("Carrot");
        // list.add("Onion");
        // list.add("Garlic");
        // list.add("Corn");

        // for (String crops : list) {
        // System.out.println(crops);
        // }
    }
}
