
import java.util.Scanner;

public class EncapsulationWithInputValidation{
    static class User {
        private String username;
        private int age;

        public void setUsername(String username) {
            if (username.matches("[a-zA-Z]+")) {
                this.username = username;
            } else {
                throw new IllegalArgumentException("Username must contain only letters");
            }
        }

        public String getUsername() {
            return username;
        }

        public void setAge(int age) {
            if (age >= 18) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("User must be at least 18 years old");
            }
        }

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
