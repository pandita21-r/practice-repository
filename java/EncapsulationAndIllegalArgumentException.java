// Another encap practice but a little polished this time

package package1;

import java.util.Scanner;

public class TestRoom2 {
    static class User {
        private String username;
        private int age;

        // Setter for username
        public void setUsername(String username) {
            if (username.matches("[a-zA-Z]+")) {
                this.username = username;
            } else {
                throw new IllegalArgumentException("Username must contain only letters");
            }
        }
        // Getter for username
        public String getUsername() {
            return username;
        }

        // Setter for age
        public void setAge(int age) {
            if (age >= 18) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("User must be at least 18 years old");
            }
        }

        // Getter for age
        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("Enter username: ");
        String username = sc.nextLine();

        System.out.println("Enter age:");
        int age = sc.nextInt();

        // try-catch for IllegalArgumentException para hindi mag crash ang program.
        try {
            user.setUsername(username);
            user.setAge(age);

            System.out.println("User created successfully");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Age: " + user.getAge());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
