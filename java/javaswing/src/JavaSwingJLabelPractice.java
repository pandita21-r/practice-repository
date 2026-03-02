import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaSwingJLabelPractice {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("java/javaswing/SensationalIcon.png"); // Create a new image icon 

        JLabel label = new JLabel(); // Create a label
        label.setText("Sensational"); // Sets the text of the label
        label.setIcon(image); // Add the new created image icon to the label

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label); // Add the label to the frame

    }
}
