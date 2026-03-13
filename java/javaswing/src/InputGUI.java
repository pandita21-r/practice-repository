import javax.swing.*;
public class InputGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("User Input Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        // Create text field (input bar)
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 50, 200, 30);

        // Create button
        // JButton button = new JButton("Submit");
        // button.setBounds(260, 50, 80, 30);

        // Create label to show output
        JLabel label = new JLabel();
        label.setBounds(50, 100, 300, 30);

        // Button action
        // button.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {

        // String text = inputField.getText(); // get user input
        // label.setText("You typed: " + text); // display it

        // inputField.setText(""); // clear input
        // }
        // });
        inputField.addActionListener(e -> {
            String text = inputField.getText();
            label.setText("You typed: " + text);
            inputField.setText("");
        });
        // Add components
        frame.add(inputField);
        // frame.add(button);
        frame.add(label);

        frame.setVisible(true);
    }
}