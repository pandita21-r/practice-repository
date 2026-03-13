package javaswing.testroom;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI {

    public static void start() {
        JFrame frame = new JFrame("Input");
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBounds(100, 110, 250,100);

        JLabel nameLabel = new JLabel("Username: ");
        JTextField nameField = new JTextField(15);

        inputPanel.add(nameLabel, BorderLayout.WEST);
        inputPanel.add(nameField, BorderLayout.CENTER);

        frame.add(inputPanel);
        frame.setVisible(true);
    }
}