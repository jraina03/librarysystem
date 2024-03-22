package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DeleteLibrarian extends JFrame implements ActionListener {
    // Array to store column names
    String x[] = {"Id", "Name", "Password", "Email", "Contact", "Address", "City"};
    // Button for deleting librarian
    JButton bt1;
    // 2D array to store librarian data
    String y[][] = new String[50][7];
    // Variables for iterating through the array
    int i = 0, j = 0;
    // Table to display librarian data
    JTable t;
    // Font for UI elements
    Font f;
    // Text field for input
    JTextField tf1;
    // Panel for UI layout
    JPanel p1;
    // Label for title
    JLabel l1;

    // Constructor for DeleteLibrarian class
    DeleteLibrarian() {
        super("DELETE LIBRARIAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(1, 1);
        setSize(1000, 400);
        f = new Font("Arial black", Font.BOLD, 20); // Set font style and size

        try {
            ConnectionClass obj = new ConnectionClass(); // Create database connection object
            String q = "Select * from librarian"; // SQL query to fetch librarian data
            ResultSet rest = obj.stm.executeQuery(q); // Execute the query
            while (rest.next()) {
                // Store librarian data in the array
                y[i][j++] = rest.getString("Lid");
                y[i][j++] = rest.getString("Name");
                y[i][j++] = rest.getString("Password");
                y[i][j++] = rest.getString("Email");
                y[i][j++] = rest.getString("Contact");
                y[i][j++] = rest.getString("Address");
                y[i][j++] = rest.getString("City");
                i++;
                j = 0;
            }
            DefaultTableModel model = new DefaultTableModel(y, x); // Create table model with data and column names
            t = new JTable(model); // Create table with model
            t.setFont(f); // Set font for table

            // Enlarge column sizes
            int[] columnWidths = {100, 200, 150, 250, 150, 200, 150}; // Adjust the values as needed
            TableColumn column;
            for (int i = 0; i < x.length; i++) {
                column = t.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }

            // Enlarge row size
            int rowHeight = 30; // Adjust the row height as needed
            t.setRowHeight(rowHeight);
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace if an exception occurs
        }

        JScrollPane sp = new JScrollPane(t); // Add table to scroll pane
        l1 = new JLabel("DELETE LIBRARIAN"); // Create label
        tf1 = new JTextField(); // Create text field
        tf1.setFont(f); // Set font for text field
        tf1.setPreferredSize(new Dimension(200, 30)); // Enlarge the input bar
        bt1 = new JButton("DELETE"); // Create delete button
        bt1.addActionListener(this); // Add action listener to delete button
        l1.setFont(f); // Set font for label
        bt1.setFont(f); // Set font for button

        p1 = new JPanel(); // Create panel
        // p1.setLayout(new GridLayout(1, 3, 10, 10); // Set layout for panel
        p1.add(l1); // Add label to panel
        p1.add(tf1); // Add text field to panel
        p1.add(bt1); // Add button to panel

        setLayout(new BorderLayout(10, 10)); // Set layout for frame
        add(sp, "Center"); // Add scroll pane to center of frame
        add(p1, "South"); // Add panel to south of frame
    }

    // actionPerformed method for handling button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) { // If "DELETE" button is clicked
            int id = Integer.parseInt(tf1.getText()); // Get librarian ID from text field
            try {
                ConnectionClass obj = new ConnectionClass(); // Create database connection object
                String q = "delete from librarian where Lid='" + id + "'"; // SQL query to delete librarian
                int res = obj.stm.executeUpdate(q); // Execute the query
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "YOUR DATA SUCCESSFULLY DELETED"); // Show success message
                    this.setVisible(false); // Hide current frame
                    new DeleteLibrarian().setVisible(true); // Show new instance of DeleteLibrarian frame
                } else {
                    JOptionPane.showMessageDialog(null, "YOUR DATA DID NOT SUCCESSFULLY DELETED"); // Show error message
                    this.setVisible(false); // Hide current frame
                    new DeleteLibrarian().setVisible(true); // Show new instance of DeleteLibrarian frame
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Print stack trace if an exception occurs
            }
        }
    }

    // Main method for testing the DeleteLibrarian class
    public static void main(String[] args) {
        new DeleteLibrarian().setVisible(true); // Creating an instance of DeleteLibrarian and making it visible
    }
}
