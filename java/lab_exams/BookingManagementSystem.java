package lab_exams;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.io.*;

public class BookingManagementSystem extends JFrame {

    private static final String FILE_PATH = "SamalBooking.txt";
    private static final String[] COLS = {
            "Booking Number", "Customer", "Category", "Date", "Pax",
            "Destination", "Payment"
    };
    private final DefaultTableModel model = new DefaultTableModel(COLS, 0);
    private final JTable table = new JTable(model);
    private final JTextField[] fields = new JTextField[COLS.length];

    public BookingManagementSystem() {
        setTitle("Samal Island Hopping Booking System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        initListeners();

        setVisible(true);
    }

    private void initUI() {
        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel form = new JPanel(new GridLayout(2, COLS.length, 6, 5));

        for (String row : COLS) {
            form.add(new JLabel(row));
        }
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField();
            form.add(fields[i]);
        }

        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("ADD");
        JButton btnUpdate = new JButton("UPDATE");
        JButton btnDelete = new JButton("DELETE");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(form, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

    }
    private void initListeners(){
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();

            if(row == -1) return;

            for(int i = 0; i < fields.length; i++){
                fields[i].setText(String.valueOf(model.getValueAt(row, i)));
            }
        });
   }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingManagementSystem());
    }
}