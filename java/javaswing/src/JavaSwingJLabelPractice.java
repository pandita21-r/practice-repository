import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaSwingJLabelPractice {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("java/javaswing/SensationalIcon.png"); // Create a new image icon 

        JLabel label = new JLabel(); // Create a label
        label.setText("Sensational"); // Sets the text of the label
        label.setIcon(image); // Add the new created image icon to the label
        label.setHorizontalTextPosition(JLabel.CENTER); // Sets the position of the text of the label to icon(image). Can be set to RIGHT, LEFT, and CENTER.
        label.setVerticalTextPosition(JLabel.TOP); // Sets the position of the text of the label to icon(image). Can be set to TOP, BOTTOM, and CENTER.
        label.setForeground(new Color(177, 3, 252)); // Set font color of text
        label.setFont(new Font("MV Boli", Font.BOLD, 25)); // Set font of the label
        label.setIconTextGap(-8); // Set gap of text to image
        label.setBackground(Color.BLACK); // Set the background color
        label.setOpaque(true); // Set to true to display/apply the "setBackgound" of false if you dont want apply the "setBackgound"

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label); // Add the label to the frame

    }
}
