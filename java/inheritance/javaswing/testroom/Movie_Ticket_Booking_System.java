package inheritance.javaswing.testroom;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Movie_Ticket_Booking_System extends JFrame {

    private JTextField customerField;
    private JTextField ticketField;

    private JComboBox<String> movieSelectionBox;

    private JRadioButton regularSeatButton;
    private JRadioButton premiumSeatButton;
    private JRadioButton vipSeatButton;

    private JCheckBox glassesCheckBox;
    private JCheckBox popcornCheckBox;
    private JCheckBox softDrinkCheckBox;

    public Movie_Ticket_Booking_System() {
        setTitle("Movie Ticket Booking System");
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

        customerField = new JTextField(20);
        gbc.gridx = 1;
        add(customerField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Movie Selection: "), gbc);

        String[] movieSelection = { "Select", "Avengers", "Inception", "Titanic", "Jurassic Park", "Interstellar" };
        movieSelectionBox = new JComboBox<>(movieSelection);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(movieSelectionBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Number of Tickets: "), gbc);

        ticketField = new JTextField(20);
        gbc.gridx = 1;
        add(ticketField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Seat Type: "), gbc);

        JPanel seatPanel = new JPanel();

        regularSeatButton = new JRadioButton("Regular");
        premiumSeatButton = new JRadioButton("Premium");
        vipSeatButton = new JRadioButton("VIP");

        ButtonGroup seatButtonGroup = new ButtonGroup();
        seatButtonGroup.add(regularSeatButton);
        seatButtonGroup.add(premiumSeatButton);
        seatButtonGroup.add(vipSeatButton);

        seatPanel.add(regularSeatButton);
        seatPanel.add(premiumSeatButton);
        seatPanel.add(vipSeatButton);

        gbc.gridx = 1;
        add(seatPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Add-ons: "), gbc);

        JPanel addonsPanel = new JPanel();

        glassesCheckBox = new JCheckBox("3D Glasses");
        popcornCheckBox = new JCheckBox("Popcorn");
        softDrinkCheckBox = new JCheckBox("Soft Drink");

        addonsPanel.add(glassesCheckBox);
        addonsPanel.add(popcornCheckBox);
        addonsPanel.add(softDrinkCheckBox);

        gbc.gridx = 1;
        add(addonsPanel, gbc);

        JButton bookTicketButton = new JButton("Book ticket");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(bookTicketButton, gbc);

        bookTicketButton.addActionListener(e -> handleSubmit());

    }

    private void handleSubmit() {
        if (customerField.getText().isEmpty()) {
            showError("Customer name is required!");
            return;
        }
        if (movieSelectionBox.getSelectedItem().toString().equals("Select")) {
            showError("Movies selection is required!");
            return;
        }
        if (ticketField.getText().isEmpty()) {
            showError("Ticket number is required!");
            return;
        }
        if (!regularSeatButton.isSelected() && !premiumSeatButton.isSelected() && !vipSeatButton.isSelected()) {
            showError("Please select a seat type!");
            return;
        }

        String ticketNumberText = ticketField.getText().trim();
        int numberOfTicket;

        try {
            numberOfTicket = Integer.parseInt(ticketNumberText);
        } catch (NumberFormatException ex) {
            showError("Number of ticket must be a number!");
            return;
        }
        if (numberOfTicket <= 0) {
            showError("Number of ticket must be greater than 0!");
            return;
        }

        String movie = movieSelectionBox.getSelectedItem().toString();
        double moviePrice = 0;

        switch (movie) {
            case "Avengers":
                moviePrice = 300 * numberOfTicket;
                break;
            case "Inception":
                moviePrice = 280 * numberOfTicket;
                break;
            case "Titanic":
                moviePrice = 250 * numberOfTicket;
                break;
            case "Jurassic Park":
                moviePrice = 270 * numberOfTicket;
                break;
            case "Interstellar":
                moviePrice = 320 * numberOfTicket;
                break;
        }
        double selectedSeat = 0;

        if (premiumSeatButton.isSelected())
            selectedSeat += 100 * numberOfTicket;
        if (vipSeatButton.isSelected())
            selectedSeat += 200 * numberOfTicket;

        double addonsCharge = 0;
        if (glassesCheckBox.isSelected())
            addonsCharge += 50;
        if (popcornCheckBox.isSelected())
            addonsCharge += 80;
        if (softDrinkCheckBox.isSelected())
            addonsCharge += 60;

        double movieAndSeatTotal = moviePrice + selectedSeat;

        double total = movieAndSeatTotal + addonsCharge;

        String seatType = "";
        if (regularSeatButton.isSelected())
            seatType += "Regular";
        if (premiumSeatButton.isSelected())
            seatType += "Premium";
        if (vipSeatButton.isSelected())
            seatType += "VIP";

        ArrayList<String> addons = new ArrayList<>();

        if (glassesCheckBox.isSelected())
            addons.add("3D Glasses");
        if (popcornCheckBox.isSelected())
            addons.add("Popcorn");
        if (softDrinkCheckBox.isSelected())
            addons.add("Soft Drink");

        String addonsText = addons.isEmpty() ? "None" : String.join(", ", addons);

        String info = "Customer Name: " + customerField.getText() +
                "\nMovie: " + movieSelectionBox.getSelectedItem().toString() +
                "\nTickets: " + numberOfTicket +
                "\nSeat Type: " + seatType +
                "\nAdd-ons: " + addonsText +
                "\nTotal Price: " + total;

        JOptionPane.showMessageDialog(this, info, "Ticket Booking System", JOptionPane.INFORMATION_MESSAGE);

    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Movie_Ticket_Booking_System().setVisible(true));
    }
}
