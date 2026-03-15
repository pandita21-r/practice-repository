import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class NestedLayoutInCenterPanel {
    public static void main(String[] args) {

        JLabel label1 = new JLabel("NORTH");
        JLabel label2 = new JLabel("SOUTH");
        JLabel label3 = new JLabel("EAST");
        JLabel label4 = new JLabel("WEST");

        JPanel northPanel = new JPanel();
        northPanel.add(label1);
        northPanel.setBackground(Color.ORANGE);
        northPanel.setPreferredSize(new Dimension(0, 80));

        JPanel southPanel = new JPanel();
        southPanel.add(label2);
        southPanel.setBackground(Color.GREEN);
        southPanel.setPreferredSize(new Dimension(0, 80));

        JPanel eastPanel = new JPanel();
        eastPanel.add(label3);
        eastPanel.setBackground(Color.PINK);
        eastPanel.setPreferredSize(new Dimension(80, 0));

        JPanel westPanel = new JPanel();
        westPanel.add(label4);
        westPanel.setBackground(Color.YELLOW);
        westPanel.setPreferredSize(new Dimension(80, 0));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel l1 = new JLabel("1");
        JLabel l2 = new JLabel("2");
        JLabel l3 = new JLabel("3");
        JLabel l4 = new JLabel("4");
        
        JPanel small1 = new JPanel();
        small1.setBackground(Color.cyan);
        small1.add(l1);
        JPanel small2 = new JPanel();
        small2.setBackground(Color.red);
        small2.add(l2);
        JPanel small3 = new JPanel();
        small3.setBackground(Color.gray);
        small3.add(l3);
        JPanel small4 = new JPanel();
        small4.setBackground(Color.lightGray);
        small4.add(l4);

        centerPanel.add(small1);
        centerPanel.add(small2);
        centerPanel.add(small3);
        centerPanel.add(small4);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
