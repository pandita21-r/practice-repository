package lab_exams;

import javax.swing.*;
import java.awt.*;
    @SuppressWarnings("all")
public class Personal_Information_Form extends JFrame {
    public Personal_Information_Form() {
        setTitle("Information Form SET A");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Full Name: "), gbc);

        JTextField fullNamTextField = new JTextField(20);
        gbc.gridx = 1;
        add(fullNamTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Age: "), gbc);

        JTextField ageTextField = new JTextField(20);
        gbc.gridx = 1;
        add(ageTextField, gbc);

        JPanel genderPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Gender: "), gbc);

        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton otherButton = new JRadioButton("Other");

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(femaleButton);
        genderButtonGroup.add(maleButton);
        genderButtonGroup.add(otherButton);

        genderPanel.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(otherButton);

        gbc.gridx = 1;
        add(genderPanel, gbc);

        String[] civilStatus = { "Select", "Single", "Married", "Divorced", "Widowed" };
        JComboBox<String> civilStatusComboBox = new JComboBox<>(civilStatus);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Civil Stauts: "), gbc);

        gbc.gridx = 1;
        add(civilStatusComboBox, gbc);

        JPanel hobbiesPanel = new JPanel();

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Hobbies: "), gbc);

        JCheckBox sportsCheckBox = new JCheckBox("Sports");
        JCheckBox musicCheckBox = new JCheckBox("Music");
        JCheckBox readingCheckBox = new JCheckBox("Reading");
        JCheckBox travelingCheckBox = new JCheckBox("Traveling");
        JCheckBox gamingCheckBox = new JCheckBox("Gaming");

        hobbiesPanel.add(sportsCheckBox);
        hobbiesPanel.add(musicCheckBox);
        hobbiesPanel.add(readingCheckBox);
        hobbiesPanel.add(travelingCheckBox);
        hobbiesPanel.add(gamingCheckBox);

        gbc.gridx = 1;
        add(hobbiesPanel, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {

            String ageText = ageTextField.getText().trim();

            if (ageText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Age is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int age;
            try {
                age = Integer.parseInt(ageText);    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Age must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gender = maleButton.isSelected() ? "Male"
                    : femaleButton.isSelected() ? "Female" : otherButton.isSelected() ? "Other" : "Not Specified";

            String hobbies = sportsCheckBox.isSelected() ? "Sports"
                    : musicCheckBox.isSelected() ? "Music"
                            : readingCheckBox.isSelected() ? "Reading"
                                    : travelingCheckBox.isSelected() ? "Traveling"
                                            : gamingCheckBox.isSelected() ? "Gaming" : "Not Specified";

            String info = "Full Name: " + fullNamTextField.getText() +
                    "\nAge: " + ageTextField.getText() +
                    "\nGender: " + gender +
                    "\nCivil Status: " + civilStatusComboBox.getSelectedItem().toString() +
                    "\nHobbies: " + hobbies;

            JOptionPane.showMessageDialog(this, info, "Information Form", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Personal_Information_Form().setVisible(true));
    }
}
