package javaswing.testroom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestRoom1 {

    static class PersonalData {
        private String name;
        private String lastName;

        public PersonalData(String name, String lastName) {
            if (name.isBlank() || name == null) {
                throw new IllegalArgumentException("Name cannot be blank or null.");
            }
            this.name = name;
            this.lastName = lastName;
        }
    }

    @SuppressWarnings("all")
    public class UserInputUI {
        private static ArrayList<PersonalData> data = new ArrayList();

        public static void start(Scanner sc) {
            String name;
            String lastName;

            System.out.print("Enter your last first name: ");
            name = sc.nextLine();
            System.out.print("Enter your last name: ");
            lastName = sc.nextLine();

            data.add(new PersonalData(name, lastName));
            SaveData.write("data.txt", data);
            ReadData.read("data.txt");
        }
    }

    public class SaveData {

        private SaveData() {
            // Utility class
        }

        public static void write(String fileName, ArrayList<PersonalData> data) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (PersonalData p : data) {
                    writer.write("Your name is: " + p.name + "\nYour last name is: " + p.lastName);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ReadData {
        private ReadData() {
            // Util class again!
        }

        public static void read(String fileName) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while ((fileName = reader.readLine()) != null) {
                    System.out.println(fileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Sucessfully read data.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserInputUI.start(sc);
    }
}