import javax.swing.*;
import java.awt.*;


public class FlowLayoutBasicsPractice {
    public static void main(String[] args) {

        JLabel label = new JLabel("Resize the window to see wrapping");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.CYAN);
        label.setOpaque(true);

        JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20 ,20));
        flowPanel.setBackground(Color.LIGHT_GRAY);
        flowPanel.setOpaque(true);

        JButton button1 = new JButton("One");
        button1.setMargin(new Insets(5,10,5,10)); // Button padding 
        JButton button2 = new JButton("Two");
        button2.setMargin(new Insets(5,10,5,10));  
        JButton button3 = new JButton("Three");
        button3.setMargin(new Insets(5,10,5,10));  
        JButton button4 = new JButton("Four");
        button4.setMargin(new Insets(5,10,5,10));  
        JButton button5 = new JButton("Five");
        button5.setMargin(new Insets(5,10,5,10));  

        // Flow Layout teaches natural size!!
        flowPanel.add(button1);
        flowPanel.add(button2);
        flowPanel.add(button3);
        flowPanel.add(button4);
        flowPanel.add(button5);

        JFrame frame = new JFrame("Flow Layout Practice");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(flowPanel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
