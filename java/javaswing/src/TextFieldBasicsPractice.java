import javax.swing.*;
import java.awt.*;

public class TextFieldBasicsPractice {
    public static void main(String[] args) {

        JLabel label = new JLabel("Type something and press ENTER");
        label.setForeground(Color.CYAN);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        JLabel label2 = new JLabel("Output appears here");
        label2.setForeground(Color.RED);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);

        JTextField inputField = new JTextField(20);
        inputField.addActionListener(e -> {
            String txt = inputField.getText();
            label2.setText("User typed: " + txt);
            inputField.setText("");
        });

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label, BorderLayout.NORTH);
        frame.add(label2, BorderLayout.SOUTH);
        frame.add(inputField, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
