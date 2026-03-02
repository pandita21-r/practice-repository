import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaSwingJFramePractice {
    public static void main(String[] args) {

        // TO DO: Learn JFrame!
        JFrame frame = new JFrame(); // Creates a frame

        frame.setSize(500, 400); // Sets x-dimension and y-dimension
        frame.setVisible(true); // Make frame visible
        frame.setTitle("Sensational"); // Sets the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the Frame
        frame.setResizable(true); // Prevent frame from being resized, and can be set to true if you want to be resizable
        
        ImageIcon image = new ImageIcon("java/javaswing/Sensational.jpg"); // Create an ImageIcon "Sensational"
        frame.setIconImage(image.getImage()); // Change the icon of the framek
        frame.getContentPane().setBackground(Color.BLACK); // Sets the color of the background
        // frame.getContentPane().setBackground(new Color(255, 255, 255)); // Sets the color of the background using RGB or Hexidecimal color values

    }
}
