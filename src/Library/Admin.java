package Library; // Package declaration for the Library package

import java.awt.event.*; // Importing classes related to AWT event handling
import java.awt.*; // Importing AWT classes
import javax.swing.*; // Importing Swing classes
import java.sql.*; // Importing SQL classes

// Class declaration for Admin, extending JFrame and implementing ActionListener interface
public class Admin extends JFrame implements ActionListener {
    JLabel l1, l2, l3; // Declaration of JLabel variables
    JButton bt1, bt2; // Declaration of JButton variables
    JPanel p1, p2; // Declaration of JPanel variables
    Font f, f1; // Declaration of Font variables
    JTextField tf1; // Declaration of JTextField variable
    JPasswordField pf1; // Declaration of JPasswordField variable

    // Constructor for Admin class
    Admin() {
        super("ADMIN LOGIN PAGE"); // Calling superclass constructor with window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Setting window to maximized state
        setLocation(500, 350); // Setting initial location of the window
        setSize(500, 200); // Setting initial size of the window

        f = new Font("cooper black", Font.BOLD, 50); // Creating Font object
        f1 = new Font("cooper black", Font.BOLD, 60); // Creating Font object

        l1 = new JLabel("ADMIN "); // Creating JLabel for "ADMIN"
        l2 = new JLabel("NAME "); // Creating JLabel for "NAME"
        l3 = new JLabel("PASSWORD"); // Creating JLabel for "PASSWORD"

        bt1 = new JButton("LOGIN"); // Creating JButton for "LOGIN"
        bt2 = new JButton("CANCEL"); // Creating JButton for "CANCEL"

        bt1.addActionListener(this); // Adding action listener to "LOGIN" button
        bt2.addActionListener(this); // Adding action listener to "CANCEL" button

        tf1 = new JTextField(); // Creating JTextField for user input
        pf1 = new JPasswordField(); // Creating JPasswordField for password input

        // Setting fonts for components
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        pf1.setFont(f1);

        // Aligning label horizontally
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.white); // Setting foreground color of label to white

        // Creating panel for title
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10)); // Setting layout for panel
        p1.add(l1); // Adding label to panel
        p1.setBackground(Color.black); // Setting background color of panel to black

        // Creating panel for input fields and buttons
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10)); // Setting layout for panel
        p2.add(l2); // Adding label for name
        p2.add(tf1); // Adding text field for name input
        p2.add(l3); // Adding label for password
        p2.add(pf1); // Adding password field for password input
        p2.add(bt1); // Adding login button
        p2.add(bt2); // Adding cancel button

        // Setting layout for main frame
        setLayout(new BorderLayout(10, 10));
        add(p1, "North"); // Adding title panel to the north position
        add(p2, "Center"); // Adding input panel to the center position
    }

    // Method to handle actionPerformed event
    public void actionPerformed(ActionEvent e) {
        String name = tf1.getText(); // Getting name input from text field
        String pass = pf1.getText(); // Getting password input from password field

        // Handling action events for buttons
        if (e.getSource() == bt1) { // If login button is clicked
            try {
                ConnectionClass obj = new ConnectionClass(); // Creating ConnectionClass object
                String s = "select * from admin where username='" + name + "' and password='" + pass + "'";

                ResultSet rest = obj.stm.executeQuery(s); // Executing query
                if (rest.next()) { // If query returns a result
                    new AdminSection().setVisible(true); // Open AdminSection window
                    this.setVisible(false); // Hide the current Admin login window
                } else {
                    JOptionPane.showMessageDialog(null, "YOUR NAME AND PASSWORD IS WRONG"); // Displaying error message
                    this.setVisible(false); // Hide the current window
                    this.setVisible(true); // Displaying the window again
                }
            } catch (Exception ee) {
                ee.printStackTrace(); // Printing stack trace in case of exception
            }
        }
        if (e.getSource() == bt2) { // If cancel button is clicked
            this.setVisible(false); // Hide the current window
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new Admin().setVisible(true); // Creating and displaying Admin login window
    }
}
