package lab_exams;

import javax.swing.*;
import java.awt.*;

public class Restaurant_Order_System extends JFrame {
    public Restaurant_Order_System() {
        setTitle("Order System");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Customer Name: "), gbc);

        JTextField customerField = new JTextField(20);
        gbc.gridx = 1;
        add(customerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Menu Selection: "), gbc);

        String[] menuSelection = { "Select", "Burger", "Pizza", "Pasta", "Salad", "Steak" };
        JComboBox<String> menuComboBox = new JComboBox<>(menuSelection);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(menuComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Quantity: "), gbc);

        JTextField quantityField = new JTextField(20);
        gbc.gridx = 1;
        add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Additional Request: "), gbc);

        JPanel additionalRequestPanel = new JPanel();

        JCheckBox extraCheese = new JCheckBox("Extra Cheese");
        JCheckBox noOnion = new JCheckBox("No Onions");
        JCheckBox spicy = new JCheckBox("Spicy");
        JCheckBox addDrink = new JCheckBox("Add Drink");

        additionalRequestPanel.add(extraCheese);
        additionalRequestPanel.add(noOnion);
        additionalRequestPanel.add(spicy);
        additionalRequestPanel.add(addDrink);

        gbc.gridx = 1;
        add(additionalRequestPanel, gbc);

        JButton orderButton = new JButton("Place Order");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(orderButton, gbc);

        orderButton.addActionListener(e -> {
            if (customerField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Customer name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (menuComboBox.getSelectedItem().toString().equals("Select")) {
                JOptionPane.showMessageDialog(null, "Menu selection is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String quantityText = quantityField.getText().trim();

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Quantity must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String item = menuComboBox.getSelectedItem().toString();
            double price = 0;
            switch (item) {
                case "Burger":
                    price = 120;
                    break;
                case "Pizza":
                    price = 350;
                    break;
                case "Pasta":
                    price = 250;
                    break;

                case "Salad":
                    price = 180;
                    break;
                case "Steak":
                    price = 500;
                    break;
            }

            double addonCost = 0;

            if (extraCheese.isSelected())
                addonCost += 30;
            if (addDrink.isSelected())
                addonCost += 50;

            double total = (price * quantity) + addonCost;

            String addons = "";
            if (extraCheese.isSelected())
                addons += "Extra Cheese";
            if (noOnion.isSelected())
                addons += "No Onions";
            if (spicy.isSelected())
                addons += "Spicy";
            if (addDrink.isSelected())
                addons += "Drink";

            String info = "Customer Name: " + customerField.getText() +
                    "\nOrder: " + menuComboBox.getSelectedItem().toString() +
                    "\nQuantity: " + quantityField.getText() +
                    "\nAdd-ons: " + addons +
                    "\nTotal Price: ₱" + total;

            JOptionPane.showMessageDialog(this, info, "Order System", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Restaurant_Order_System().setVisible(true));
    }
}
