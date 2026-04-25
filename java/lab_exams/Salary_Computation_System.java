package lab_exams;

import javax.swing.*;
import java.awt.*;

public class Salary_Computation_System extends JFrame {
    public Salary_Computation_System() {
        setTitle("Salary Computation System");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Employee Name: "), gbc);

        JTextField employeeTextField = new JTextField(20);
        gbc.gridx = 1;
        add(employeeTextField, gbc);

        String[] jobPositions = { "Select", "Manager", "Developer", "Technician", "Clerk" };
        JComboBox<String> jobPositionComboBox = new JComboBox<>(jobPositions);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Job Position: "), gbc);

        gbc.gridx = 1;
        add(jobPositionComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Basic Salary: "), gbc);

        JTextField salaryField = new JTextField();
        gbc.gridx = 1;
        add(salaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Deductions: "), gbc);

        JPanel deductionPanel = new JPanel();

        JCheckBox sssCheckBox = new JCheckBox("SSS");
        JCheckBox pagIBIGCheckBox = new JCheckBox("Pag-IBIG");
        JCheckBox philHealthCheckBox = new JCheckBox("PhilHealth");

        deductionPanel.add(sssCheckBox);
        deductionPanel.add(pagIBIGCheckBox);
        deductionPanel.add(philHealthCheckBox);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(deductionPanel, gbc);

        JButton computeButton = new JButton("Compute");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(computeButton, gbc);

        computeButton.addActionListener(e -> {
            if (employeeTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Employee name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (jobPositionComboBox.getSelectedItem().equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please select job position", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String salaryText = salaryField.getText().trim();

            if (salaryText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Basic Salary is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salary;
            try {
                salary = Double.parseDouble(salaryText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Basic Salary must be a number!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalDeductions = 0;

            if (sssCheckBox.isSelected())
                totalDeductions += salary * 0.05;
            if (pagIBIGCheckBox.isSelected())
                totalDeductions += salary * 0.03;
            if (philHealthCheckBox.isSelected())
                totalDeductions += salary * 0.02;

            double netSalary = salary - totalDeductions;

            String info = "Employee Name: " + employeeTextField.getText() +
                    "\nPosition: " + jobPositionComboBox.getSelectedItem() +
                    "\nBasic Salary: " + salaryField.getText() +
                    "\nTotal Deductions: " + totalDeductions +
                    "\nNet Salary: " + netSalary;

            JOptionPane.showMessageDialog(this, info, "Salary Result", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Salary_Computation_System().setVisible(true));
    }
}