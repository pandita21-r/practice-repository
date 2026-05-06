package lab_exams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Hospital_Management_System extends JFrame {

    public Hospital_Management_System() {

        setTitle("Hospital Management System");
        setSize(1100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        String[] columns = { "Patient ID", "Full Name", "Age", "Gender", "Contact Number", "Admission Date",
                "Diagnosis" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;

        gbc.gridx = 0;
        panel.add(new JLabel("Patient ID"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel("Full Name"), gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Age"), gbc);
        gbc.gridx = 3;
        panel.add(new JLabel("Gender"), gbc);
        gbc.gridx = 4;
        panel.add(new JLabel("Contact Number"), gbc);
        gbc.gridx = 5;
        panel.add(new JLabel("Admission Date"), gbc);
        gbc.gridx = 6;
        panel.add(new JLabel("Diagnosis"), gbc);

        gbc.gridy = 1;

        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField ageField = new JTextField(15);
        JTextField contactField = new JTextField(15);
        JTextField dateField = new JTextField(15);
        JTextField diagnosisField = new JTextField(15);

        JComboBox<String> genderBox = new JComboBox<>(new String[] { "Select", "Male", "Female" });

        gbc.gridx = 0;
        panel.add(idField, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);
        gbc.gridx = 2;
        panel.add(ageField, gbc);
        gbc.gridx = 3;
        panel.add(genderBox, gbc);
        gbc.gridx = 4;
        panel.add(contactField, gbc);
        gbc.gridx = 5;
        panel.add(dateField, gbc);
        gbc.gridx = 6;
        panel.add(diagnosisField, gbc);

        JButton addButton = new JButton("Add Patient");

        gbc.gridy = 2;
        gbc.gridx = 6;
        panel.add(addButton, gbc);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {

            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || ageField.getText().isEmpty()
                    || genderBox.getSelectedItem().equals("Select") || contactField.getText().isEmpty()
                    || dateField.getText().isEmpty() || diagnosisField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] data = { idField.getText(), nameField.getText(), ageField.getText(),
                    genderBox.getSelectedItem().toString(), contactField.getText(), dateField.getText(),
                    diagnosisField.getText() };

            model.addRow(data);

            try (FileWriter writer = new FileWriter("patients.txt", true)) {
                writer.write(String.join(",", data) + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving file");
            }

            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            genderBox.setSelectedIndex(0);
            contactField.setText("");
            dateField.setText("");
            diagnosisField.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Hospital_Management_System().setVisible(true));
    }
}