package javaswing.testroom;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI {

    public static void start() {
        JLabel label1 = new JLabel();

        label1.setText("Hello!");
        label1.setBackground(Color.DARK_GRAY);
        label1.setForeground(new Color(177, 3, 252));
        label1.setFont(new Font("MV Boli", Font.BOLD, 20));

        label1.setOpaque(true);

        label1.setBounds(15, 20, 100, 80);
        label1.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel1 = new JPanel();// JPanel's layout is FLowLayout by default! set it to null if you want your set bounds to work!

        panel1.setLayout(null);
        panel1.setBackground(Color.GREEN);
        panel1.setBounds(0, 0, 140, 120);
        panel1.add(label1);

        JFrame frame = new JFrame("Input");
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(panel1);

        frame.setVisible(true);
    }
}