package Library; // Package declaration
import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components
import java.sql.*; // Importing necessary classes for database interaction
import javax.swing.table.TableColumn; // Import TableColumn

// Class declaration extending JFrame
public class ViewLibrarian extends JFrame {
    String x[] = {"Id", "Name", "Password", "Email", "Contact", "Address", "City"}; // Column headers
    JButton bt; // Button
    String y[][] = new String[50][40]; // Data array
    int i = 0, j = 0; // Loop variables
    JTable t; // Table
    Font f, f1; // Fonts

    // Constructor
    ViewLibrarian() {
        super("LIBRARIAN INFORMATION"); // Calling superclass constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setLocation(1, 1); // Setting initial location
        setSize(1000, 400); // Setting initial size
        f = new Font("arial black", Font.BOLD, 25); // Initializing font

        try {
            ConnectionClass obj = new ConnectionClass(); // Creating database connection object
            String q = "Select * from librarian"; // SQL query to select all data from librarian table
            ResultSet rest = obj.stm.executeQuery(q); // Executing the query
            while (rest.next()) { // Loop through the result set
                // Retrieving data from the result set and storing it in the array
                y[i][j++] = rest.getString("Lid");
                y[i][j++] = rest.getString("Name");
                y[i][j++] = rest.getString("Password");
                y[i][j++] = rest.getString("Email");
                y[i][j++] = rest.getString("Contact");
                y[i][j++] = rest.getString("Address");
                y[i][j++] = rest.getString("City");
                i++; // Incrementing row index
                j = 0; // Resetting column index
            }
            t = new JTable(y, x); // Creating table with data and column headers
            t.setFont(f); // Setting font for table

            // Set preferred column width
            for (int columnIndex = 0; columnIndex < t.getColumnCount(); columnIndex++) {
                TableColumn column = t.getColumnModel().getColumn(columnIndex);
                column.setPreferredWidth(150); // You can adjust the width as needed
            }

            // Set row height
            t.setRowHeight(30); // You can adjust the row height as needed

        } catch (Exception ex) {
            ex.printStackTrace(); // Printing stack trace in case of exception
        }

        JScrollPane sp = new JScrollPane(t); // Creating scroll pane with table
        add(sp); // Adding scroll pane to the frame
    }

    // Main method
    public static void main(String[] args) {
        new ViewLibrarian().setVisible(true); // Creating an instance of ViewLibrarian and setting it visible
    }
}
