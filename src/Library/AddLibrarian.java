package Library; // Package declaration for the Library package

import java.awt.event.*; // Importing classes related to AWT event handling
import java.awt.*; // Importing AWT classes
import javax.swing.*; // Importing Swing classes
import java.sql.*; // Importing SQL classes

// Class declaration for AddLibrarian, extending JFrame and implementing ActionListener interface
public class AddLibrarian extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7; // Declaration of JLabel variables
    JButton bt1, bt2; // Declaration of JButton variables
    JPanel p1, p2; // Declaration of JPanel variables
    JTextField tf1, tf2, tf3, tf4, tf5; // Declaration of JTextField variables
    JPasswordField pf1; // Declaration of JPasswordField variable
    Font f, f1; // Declaration of Font variables

    // Constructor for AddLibrarian class
    AddLibrarian() {
        super("ADD LIBRARIAN"); // Calling superclass constructor with window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Setting window to maximized state
        setLocation(450, 400); // Setting initial location of the window
        setSize(650, 400); // Setting initial size of the window

        f = new Font("cooper black", Font.BOLD, 50); // Creating Font object
        f1 = new Font("cooper black", Font.BOLD, 60); // Creating Font object

        l1 = new JLabel("ADMIN LIBRARIAN"); // Creating JLabel for "ADMIN LIBRARIAN"
        l2 = new JLabel("NAME"); // Creating JLabel for "NAME"
        l3 = new JLabel("PASSWORD"); // Creating JLabel for "PASSWORD"
        l4 = new JLabel("EMAIL"); // Creating JLabel for "EMAIL"
        l5 = new JLabel("CONTACT"); // Creating JLabel for "CONTACT"
        l6 = new JLabel("ADDRESS"); // Creating JLabel for "ADDRESS"
        l7 = new JLabel("CITY"); // Creating JLabel for "CITY"

        tf1 = new JTextField(); // Creating JTextField for name input
        tf2 = new JTextField(); // Creating JTextField for email input
        tf3 = new JTextField(); // Creating JTextField for contact input
        tf4 = new JTextField(); // Creating JTextField for address input
        tf5 = new JTextField(); // Creating JTextField for city input

        pf1 = new JPasswordField(); // Creating JPasswordField for password input

        // Setting fonts for components
        l1.setFont(f);
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);

        l1.setForeground(Color.WHITE); // Setting foreground color of label to white
        l1.setHorizontalAlignment(JLabel.CENTER); // Aligning label horizontally

        // Setting fonts for text fields and password field
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        pf1.setFont(f);

        bt1 = new JButton("ADD LIBRARIAN"); // Creating JButton for "ADD LIBRARIAN"
        bt2 = new JButton("CANCEL"); // Creating JButton for "CANCEL"

        // Setting fonts for buttons
        bt1.setFont(f1);
        bt2.setFont(f1);

        bt1.addActionListener(this); // Adding action listener to "ADD LIBRARIAN" button
        bt2.addActionListener(this); // Adding action listener to "CANCEL" button

        p1 = new JPanel(); // Creating panel for title
        p1.setLayout(new GridLayout(1, 1, 0, 0)); // Setting layout for panel
        p1.add(l1); // Adding label to panel
        p1.setBackground(Color.BLACK); // Setting background color of panel to black

        p2 = new JPanel(); // Creating panel for input fields and buttons
        p2.setLayout(new GridLayout(7, 2, 10, 10)); // Setting layout for panel
        p2.add(l2); // Adding label for name
        p2.add(tf1); // Adding text field for name input
        p2.add(l3); // Adding label for password
        p2.add(pf1); // Adding password field for password input
        p2.add(l4); // Adding label for email
        p2.add(tf2); // Adding text field for email input
        p2.add(l5); // Adding label for contact
        p2.add(tf3); // Adding text field for contact input
        p2.add(l6); // Adding label for address
        p2.add(tf4); // Adding text field for address input
        p2.add(l7); // Adding label for city
        p2.add(tf5); // Adding text field for city input
        p2.add(bt1); // Adding "ADD LIBRARIAN" button
        p2.add(bt2); // Adding "CANCEL" button

        // Setting layout for main frame
        setLayout(new BorderLayout(10, 10));
        add(p1, "North"); // Adding title panel to the north position
        add(p2, "Center"); // Adding input panel to the center position
    }

    // Method to handle actionPerformed event
    public void actionPerformed(ActionEvent e) {
        String name = tf1.getText(); // Getting name input from text field
        String pass = pf1.getText(); // Getting password input from password field
        String email = tf2.getText(); // Getting email input from text field
        String contact = tf3.getText(); // Getting contact input from text field
        String add = tf4.getText(); // Getting address input from text field
        String city = tf5.getText(); // Getting city input from text field

        // Handling action events for buttons
        if (e.getSource() == bt1) { // If "ADD LIBRARIAN" button is clicked
            try {
                ConnectionClass obj = new ConnectionClass(); // Creating ConnectionClass object
                String q = "insert into librarian(name,password,email,contact,address,city) values ('" + name + "','" +
                        pass + "','" + email + "','" + contact + "','" + add + "','" + city + "')"; // SQL query
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
  public static void main (String[]args)
  {
      new AddLibrarian().setVisible(true);
  }
}
