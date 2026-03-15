package javaswing.testroom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        
        // Labels
        JLabel label1 = new JLabel("NORTH");
        JLabel label2 = new JLabel("SOUTH");
        JLabel label3 = new JLabel("EAST");
        JLabel label4 = new JLabel("WEST");
        JLabel label5 = new JLabel("CENTER");

        // Panels
        JPanel northPanel = new JPanel();
        northPanel.add(label1);
        northPanel.setPreferredSize(new Dimension(0,100));
        northPanel.setBackground(Color.BLUE);
        northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(0,100));
        southPanel.add(label2);
        southPanel.setBackground(Color.RED);
        southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(200,0));
        eastPanel.add(label3);
        eastPanel.setBackground(Color.MAGENTA);
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(200,0));
        westPanel.add(label4);
        westPanel.setBackground(Color.GREEN);
        westPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel centerPanel = new JPanel();
        // No "setPreferredSize" because its centered.
        centerPanel.add(label5);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400,400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
