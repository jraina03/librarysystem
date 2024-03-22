package Library; // Package declaration
import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components
import java.sql.*; // Importing necessary classes for database interaction
import javax.swing.table.TableColumn; // Import TableColumn

// Class declaration extending JFrame
public class ViewBook extends JFrame {
    // Array for column headers
    String x[] = {"Id", "Book no", "Book name", "Author", "Publisher", "Quantity", "Issued", "Date"};
    JButton bt; // Button
    String y[][] = new String[40][20]; // Data array
    int i = 0, j = 0; // Loop variables
    JTable t; // Table
    Font f, f1; // Fonts

    // Constructor
    ViewBook() {
        super("BOOK INFORMATION"); // Calling superclass constructor with title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setLocation(1, 1); // Setting initial location
        setSize(1000, 400); // Setting initial size

        f = new Font("Arial black", Font.BOLD, 20); // Initializing font
        try {
            ConnectionClass obj = new ConnectionClass(); // Creating database connection object
            String q = "Select * from addbook"; // SQL query to select all data from addbook table
            ResultSet rest = obj.stm.executeQuery(q); // Executing the query
            while (rest.next()) { // Loop through the result set
                // Retrieving data from the result set and storing it in the array
                y[i][j++] = rest.getString("id");
                y[i][j++] = rest.getString("BookNo");
                y[i][j++] = rest.getString("bookname");
                y[i][j++] = rest.getString("author");
                y[i][j++] = rest.getString("Publishre");
                y[i][j++] = rest.getString("quantity");
                y[i][j++] = rest.getString("issuebook");
                y[i][j++] = rest.getString("date");
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
        new ViewBook().setVisible(true); // Creating an instance of ViewBook and setting it visible
    }
}
