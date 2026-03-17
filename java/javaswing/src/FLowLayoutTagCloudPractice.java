import javax.swing.*;
import java.awt.*;

public class FLowLayoutTagCloudPractice {
    public static void main(String[] args) {

        JLabel label = new JLabel("Resize the window to see tag wrapping");
        label.setBackground(Color.BLACK);
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel tagPanel = new JPanel();
        tagPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        tagPanel.setBackground(Color.LIGHT_GRAY);

        JButton tag1 = new JButton("Tag 1");
        JButton tag2 = new JButton("Tag 2");
        JButton tag3 = new JButton("Tag 3");
        JButton tag4 = new JButton("Tag 4");
        JButton tag5 = new JButton("Tag 5");
        JButton tag6 = new JButton("Tag 6");
        JButton tag7 = new JButton("Tag 7");
        JButton tag8 = new JButton("Tag 8");
        JButton tag9 = new JButton("Tag 9");
        JButton tag10 = new JButton("Tag 10");
        JButton tag11 = new JButton("Tag 11");
        JButton tag12 = new JButton("Tag 12");
        JButton tag13 = new JButton("Tag 13");
        JButton tag14 = new JButton("Tag 14");
        JButton tag15 = new JButton("Tag 15");

        tagPanel.add(tag1);
        tagPanel.add(tag2);
        tagPanel.add(tag3);
        tagPanel.add(tag4);
        tagPanel.add(tag5);
        tagPanel.add(tag6);
        tagPanel.add(tag7);
        tagPanel.add(tag8);
        tagPanel.add(tag9);
        tagPanel.add(tag10);
        tagPanel.add(tag11);
        tagPanel.add(tag12);
        tagPanel.add(tag13);
        tagPanel.add(tag14);
        tagPanel.add(tag15);

        frame.add(tagPanel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
