package Library; // Package declaration for the Library package

import java.awt.event.*; // Importing classes related to AWT event handling
import java.awt.*; // Importing AWT classes
import javax.swing.*; // Importing Swing classes
import java.sql.*; // Importing SQL classes

// Class declaration for AddBook, extending JFrame and implementing ActionListener interface
public class AddBook extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6; // Declaration of JLabel variables
    JButton bt1, bt2; // Declaration of JButton variables
    JPanel p1, p2; // Declaration of JPanel variables
    Font f, f1; // Declaration of Font variables
    JTextField tf1, tf2, tf3, tf4, tf5; // Declaration of JTextField variables

    // Constructor for AddBook class
    AddBook() {
        super("ADD BOOKS"); // Calling superclass constructor with window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Setting window to maximized state
        setLocation(0, 0); // Setting initial location of the window
        setSize(650, 400); // Setting initial size of the window

        f = new Font("cooper black", Font.BOLD, 50); // Creating Font object
        f1 = new Font("cooper black", Font.BOLD, 60); // Creating Font object

        l1 = new JLabel("ADD BOOKS"); // Creating JLabel for "ADD BOOKS"
        l2 = new JLabel("BOOK NO"); // Creating JLabel for "BOOK NO"
        l3 = new JLabel("BOOK NAME"); // Creating JLabel for "BOOK NAME"
        l4 = new JLabel("AUTHOR"); // Creating JLabel for "AUTHOR"
        l5 = new JLabel("PUBLISHER"); // Creating JLabel for "PUBLISHER"
        l6 = new JLabel("QUANTITY"); // Creating JLabel for "QUANTITY"

        l1.setHorizontalAlignment(JLabel.CENTER); // Aligning label horizontally
        l1.setForeground(Color.white); // Setting foreground color of label to white

        tf1 = new JTextField(); // Creating JTextField for book number input
        tf2 = new JTextField(); // Creating JTextField for book name input
        tf3 = new JTextField(); // Creating JTextField for author input
        tf4 = new JTextField(); // Creating JTextField for publisher input
        tf5 = new JTextField(); // Creating JTextField for quantity input

        bt1 = new JButton("ADD BOOK"); // Creating JButton for "ADD BOOK"
        bt2 = new JButton("CANCEL"); // Creating JButton for "CANCEL"

        bt1.setFont(f1); // Setting font for "ADD BOOK" button
        bt2.setFont(f1); // Setting font for "CANCEL" button

        bt1.addActionListener(this); // Adding action listener to "ADD BOOK" button
        bt2.addActionListener(this); // Adding action listener to "CANCEL" button

        // Setting fonts for labels, text fields, and buttons
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);

        p1 = new JPanel(); // Creating panel for title
        p1.setLayout(new GridLayout(1, 1, 10, 10)); // Setting layout for panel
        p1.add(l1); // Adding label to panel
        p1.setBackground(Color.black); // Setting background color of panel to black

        p2 = new JPanel(); // Creating panel for input fields and buttons
        p2.setLayout(new GridLayout(6, 2, 10, 10)); // Setting layout for panel
        p2.add(l2); // Adding label for book number
        p2.add(tf1); // Adding text field for book number input
        p2.add(l3); // Adding label for book name
        p2.add(tf2); // Adding text field for book name input
        p2.add(l4); // Adding label for author
        p2.add(tf3); // Adding text field for author input
        p2.add(l5); // Adding label for publisher
        p2.add(tf4); // Adding text field for publisher input
        p2.add(l6); // Adding label for quantity
        p2.add(tf5); // Adding text field for quantity input
        p2.add(bt1); // Adding "ADD BOOK" button
        p2.add(bt2); // Adding "CANCEL" button

        // Setting layout for main frame
        setLayout(new BorderLayout(10, 10));
        add(p1, "North"); // Adding title panel to the north position
        add(p2, "Center"); // Adding input panel to the center position
    }

    // Method to handle actionPerformed event
    public void actionPerformed(ActionEvent e) {
        String bookno = tf1.getText(); // Getting book number input from text field
        String bookname = tf2.getText(); // Getting book name input from text field
        String author = tf3.getText(); // Getting author input from text field
        String publisher = tf4.getText(); // Getting publisher input from text field
        String quantity = tf5.getText(); // Getting quantity input from text field
        String date = new java.util.Date().toString(); // Getting current date

        // Handling action events for buttons
        if (e.getSource() == bt1) { // If "ADD BOOK" button is clicked
            try {
                ConnectionClass obj = new ConnectionClass(); // Creating ConnectionClass object
                String q = "insert into addbook(BookNo,Bookname,author,publishre,quantity,date) values ('" +
                        bookno + "','" + bookname + "','" + author + "','" + publisher + "','" + quantity + "','" + date + "')"; // SQL query
                int aa = obj.stm.executeUpdate(q); // Executing query
                if (aa == 1) { // If data is successfully inserted
                    JOptionPane.showMessageDialog(null, "YOUR DATA SUCCESSFULLY INSERTED"); // Displaying success message
                    this.setVisible(false); // Hide the current window
                } else {
                    JOptionPane.showMessageDialog(null, "please!, fill all details carefully"); // Displaying error message
                    this.setVisible(true); // Displaying the window again
                }
            } catch (Exception ee) {
                ee.printStackTrace(); // Printing stack trace in case of exception
            }
        }
        if (e.getSource() == bt2) { // If "CANCEL" button is clicked
            this.setVisible(false); // Hide the current window
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new AddBook().setVisible(true); // Creating and displaying AddBook window
    }
}
