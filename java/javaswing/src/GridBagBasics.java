import javax.swing.*;
import java.awt.*;

public class GridBagBasics {
    public static void main(String[] args) {

        JFrame frame = new JFrame("GridBag Spanning Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // A button that spans two columns in row 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across 2 columns
        frame.add(new JButton("Spans 2 Columns"), gbc);

        // Reset gridwidth back to 1 for the others
        gbc.gridwidth = 1;

        // Row 1, column 0
        gbc.gridy = 1;
        gbc.gridx = 0;
        frame.add(new JButton("A"), gbc);

        // Row 1, column 1
        gbc.gridx = 1;
        frame.add(new JButton("B"), gbc);

        frame.pack();
        frame.setVisible(true);

    }
}