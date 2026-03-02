import javax.swing.JFrame;

public class JavaSwingJFramePractice {
    public static void main(String[] args) {

        // TO DO: Learn JFrame!
        JFrame frame = new JFrame(); // Creates a frame

        frame.setSize(500, 400); // Sets x-dimension and y-dimension
        frame.setVisible(true); // Make frame visible
        frame.setTitle("JFrame title goes here."); // Sets the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the Frame
        frame.setResizable(false); // Prevent frame from being resized, and can be set to true if you want to be resizable
        

    }
}
