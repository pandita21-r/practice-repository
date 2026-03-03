import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JavaSwingJPanelPractice {
    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("java/javaswing/SensationalIcon.png");
        JLabel label = new JLabel();
        label.setText("Sensational");
        label.setIcon(icon);

        ImageIcon jalIcon = new ImageIcon("java/javaswing/JalIcon.jpg");
        JLabel label2 = new JLabel();
        label2.setText("Jal POGI");
        label2.setIcon(jalIcon);


        JPanel redPanel = new JPanel(); // Create the panel
        redPanel.setBackground(Color.RED); // Our color for the red panel
        redPanel.setBounds(0, 0, 250, 250); // Position of our red panel because we have "null" setLayout().
        
        JPanel bluePanel = new JPanel(); // this is the same with the red panel but different position
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250, 0, 250,250);

        JPanel greenPanel = new JPanel(); // this is the same with the red panel but different position
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 250, 500,250);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Sets the layout to null 'cause we are munually going to place all the components that we have
        frame.setSize(750, 750);
        frame.setVisible(true);
        redPanel.add(label);
        bluePanel.add(label2);
        frame.add(redPanel); // Add the red panel that we created to the frame.
        frame.add(bluePanel); // Add the blue panel that we created to the frame.
        frame.add(greenPanel); // Add the blue panel that we created to the frame.

    }
}
