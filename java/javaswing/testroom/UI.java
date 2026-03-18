package javaswing.testroom;

import java.awt.*;
import javax.swing.*;

public class UI {
    public static void start() {
        JPanel nPanel = new JPanel();
        nPanel.setBackground(Color.GREEN);
        nPanel.setPreferredSize(new Dimension(0, 90));

        JPanel sPanel = new JPanel();
        sPanel.setBackground(Color.MAGENTA);
        sPanel.setPreferredSize(new Dimension(0, 90));

        JPanel ePanel = new JPanel();
        ePanel.setBackground(Color.YELLOW);
        ePanel.setPreferredSize(new Dimension(70, 0));

        JPanel wPanel = new JPanel();
        wPanel.setBackground(Color.BLACK);
        wPanel.setPreferredSize(new Dimension(70, 0));

        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");
        JButton btn4 = new JButton("Button 4");
        JButton btn5 = new JButton("Button 5");
        JButton btn6 = new JButton("Button 6");

        JPanel cPanel = new JPanel();
        // Flow Layout teaches or automatically fix the positions of components.
        cPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        cPanel.setBackground(Color.LIGHT_GRAY);
        cPanel.add(btn1);
        cPanel.add(btn2);
        cPanel.add(btn3);
        cPanel.add(btn4);
        cPanel.add(btn5);
        cPanel.add(btn6);

        JFrame frame = new JFrame("Practice");
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(nPanel, BorderLayout.NORTH);
        frame.add(sPanel, BorderLayout.SOUTH);
        frame.add(ePanel, BorderLayout.EAST);
        frame.add(wPanel, BorderLayout.WEST);
        frame.add(cPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}