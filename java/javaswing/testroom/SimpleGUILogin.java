package javaswing.testroom;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class SimpleGUILogin {

    static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    private ArrayList<User> userList = new ArrayList<>();

    public SimpleGUILogin() {

        userList.add(new User("admin", "123"));
        userList.add(new User("test", "pass"));

        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        JLabel feedback = new JLabel("", SwingConstants.CENTER);
        feedback.setForeground(Color.BLUE);

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(feedback);

        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                feedback.setText("Fields cannot be empty!");
                feedback.setForeground(Color.RED);
                return;
            }

            boolean loggedIn = false;

            for (User u : userList) {
                if (u.getUsername().equals(username) &&
                    u.getPassword().equals(password)) {
                    loggedIn = true;
                    break;
                }
            }

            if (loggedIn) {
                feedback.setText("You are logged in!");
                feedback.setForeground(new Color(0, 128, 0));
            } else {
                feedback.setText("Invalid credentials");
                feedback.setForeground(Color.RED);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUILogin();
    }
}