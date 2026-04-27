import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VerticalBoxLayoutPractice {
    public static void main(String[] args) {

        JLabel label = new JLabel("MAIN CONTENT AREA");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(label, BorderLayout.CENTER);
        centerPanel.setBackground(Color.DARK_GRAY);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // BoxLayout! can be Y_AXIS for vertical format and X_AXIS for horizontal
        menuPanel.setBackground(Color.lightGray);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton button1 = new JButton("Home");
        // The "Integer.MAX_VALUE" is good here because we want the width stretch vertically compare to "X_AXIS" BoxLayout!!!
        // Also, this allow horizontal stretching
        button1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Width streches but the Height stay fixed. Good for BoxLayout.Y_AXIS
        button1.setAlignmentX(Component.LEFT_ALIGNMENT); // Buttons alignment!
        JButton button2 = new JButton("Profile");
        button2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton button3 = new JButton("Settings");
        button3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button3.setAlignmentX(Component.LEFT_ALIGNMENT);

        menuPanel.add(button1);
        // Repeatedly call this to apply spacing properly!
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        menuPanel.add(button2);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons
        menuPanel.add(button3);

        JFrame frame = new JFrame("Vertical Menu Example");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        // frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
