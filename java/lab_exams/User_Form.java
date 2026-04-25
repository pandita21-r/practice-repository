package lab_exams;
import javax.swing.*;

import java.awt.*;

public class User_Form extends JFrame {

    public User_Form() {

        setTitle("User Information Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(new JLabel("First Name:"), gbc);

        JTextField firstNameField = new JTextField(20);

        gbc.gridx = 1;

        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(new JLabel("Last Name:"), gbc);

        JTextField lastNameField = new JTextField(20);

        gbc.gridx = 1;

        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(new JLabel("Email:"), gbc);

        JTextField emailField = new JTextField(20);

        gbc.gridx = 1;

        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(new JLabel("Mobile:"), gbc);

        JTextField mobileField = new JTextField(20);

        gbc.gridx = 1;

        add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;

        add(new JLabel("Gender:"), gbc);

        JPanel genderPanel = new JPanel();

        JRadioButton maleButton = new JRadioButton("Male");

        JRadioButton femaleButton = new JRadioButton("Female");

        JRadioButton otherButton = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();

        genderGroup.add(maleButton);

        genderGroup.add(femaleButton);

        genderGroup.add(otherButton);

        genderPanel.add(maleButton);

        genderPanel.add(femaleButton);

        genderPanel.add(otherButton);

        gbc.gridx = 1;

        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;

        add(new JLabel("Nationality:"), gbc);

        String[] nationalityOptions = { "Select", "Filipino", "American", "British", "Canadian",
                "Australian", "Japanese", "Korean", "Chinese", "Indian", "Other" };

        JComboBox<String> nationalityBox = new JComboBox<>(nationalityOptions);

        gbc.gridx = 1;

        add(nationalityBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;

        add(new JLabel("Address:"), gbc);

        JTextArea addressArea = new JTextArea(4, 20);

        JScrollPane scrollPane = new JScrollPane(addressArea);

        gbc.gridx = 1;

        add(scrollPane, gbc);

        JButton submitButton = new JButton("Submit");

        gbc.gridx = 1;
        gbc.gridy = 8;

        add(submitButton, gbc);

        submitButton.addActionListener(e -> {

            String gender = maleButton.isSelected() ? "Male"
                    : femaleButton.isSelected() ? "Female" : otherButton.isSelected() ? "Other" : "Not Specified";

            String info = "First Name : " + firstNameField.getText() + "\nLast Name : " + lastNameField.getText()
                    + "\nEmail : " + emailField.getText()
                    + "\nMobile : " + mobileField.getText() + "\nGender : " + gender + "\n" + "Nationality : "
                    + nationalityBox.getSelectedItem().toString() + "\nAddress : " + addressArea.getText() + "\n";

            JOptionPane.showMessageDialog(this, info, "User Information", JOptionPane.INFORMATION_MESSAGE);

        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new User_Form().setVisible(true));
    }
}
