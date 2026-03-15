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

public class HorizontalBoxLayoutPractice {
    public static void main(String[] args) {

        JLabel label = new JLabel("Content goes here");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.CYAN);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(label, BorderLayout.CENTER);
        centerPanel.setBackground(Color.DARK_GRAY);

        JPanel topBar = new JPanel();
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topBar.setBackground(Color.LIGHT_GRAY);

        // This is the preferred size for our button because we are using X_AXIS BoxLayout!
        // Keeps everything neat and natural!!
        // Do not forget to set this to the BUTTON!!!
        Dimension buttonSize = new Dimension(90, 30);

        JButton button1 = new JButton("File");
        button1.setPreferredSize(buttonSize); // The "buttonSize" is the DIMENSION THAT WE CREATED ABOVE!!!
        button1.setAlignmentY(Component.CENTER_ALIGNMENT);
        JButton button2 = new JButton("Edit");
        button2.setPreferredSize(buttonSize);
        button2.setAlignmentY(Component.CENTER_ALIGNMENT);
        JButton button3 = new JButton("View");
        button3.setPreferredSize(buttonSize);
        button3.setAlignmentY(Component.CENTER_ALIGNMENT);

        topBar.add(button1);
        topBar.add(Box.createHorizontalStrut(15));
        topBar.add(button2);
        topBar.add(Box.createHorizontalStrut(15));
        topBar.add(button3);

        // "createrHorizontalGlue" para ma keep lang yung mga buttons to the left area kase this glue comes after the buttons
        // Glue creates expandable flexible space
        // Kung may new component tayong gustong ilagay dapat sa glue dapat mauna yung glue sunod yung mga new components 
        // COMPONENT / GLUE / NEW COMPONENT !!!! 
        topBar.add(Box.createHorizontalGlue());


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        // frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(topBar, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
