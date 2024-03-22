package Library; // Package declaration
import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components
import java.sql.*; // Importing necessary classes for database interaction

// Class declaration extending JFrame and implementing ActionListener interface
public class Librarian extends JFrame implements ActionListener {
    JLabel l1, l2, l3; // Labels
    JButton bt1, bt2; // Buttons
    JPanel p1, p2; // Panels
    Font f, f1; // Fonts
    JTextField tf1; // Text field for name
    JPasswordField pf1; // Password field
    
    // Constructor
    Librarian() {
        super("LIBRARIAN LOGIN PAGE"); // Calling superclass constructor with title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setLocation(450, 400); // Setting initial location
        setSize(500, 200); // Setting initial size
        
        // Initializing fonts
        f = new Font("cooper black", Font.BOLD, 50);
        f1 = new Font("cooper black", Font.BOLD, 60);
        
        // Initializing labels
        l1 = new JLabel("LIBRARIAN LOGIN");
        l2 = new JLabel("NAME");
        l3 = new JLabel("PASSWORD");
        
        // Initializing buttons
        bt1 = new JButton("LOGIN");
        bt2 = new JButton("CANCEL");
        
        // Adding ActionListener to buttons
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        // Initializing text field and password field
        tf1 = new JTextField();
        pf1 = new JPasswordField();
        
        // Setting fonts for components
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        pf1.setFont(f1);
        
        // Setting label alignment
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.white);
        
        // Initializing and setting layout for panels
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        p1.setBackground(Color.black);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(bt1);
        p2.add(bt2);
        
        // Setting layout for the frame
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
    }
    
    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        String name = tf1.getText(); // Get text from name field
        String pass = pf1.getText(); // Get text from password field
        
        // If login button is clicked
        if (e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass(); // Create database connection object
                String s = "select name ,password from librarian where name='" + name + "'and password='" + pass + "'";
                ResultSet rest = obj.stm.executeQuery(s); // Execute query
                
                // If there is a matching record
                if (rest.next()) {
                    System.out.println("done"); // Print message
                    new LibrarianSection().setVisible(true); // Open LibrarianSection frame
                    this.setVisible(false); // Hide current frame
                } else {
                    JOptionPane.showMessageDialog(null, "YOUR NAME AND PASSWORD IS WRONG"); // Show error message
                    this.setVisible(false); // Hide current frame
                    this.setVisible(true); // Show current frame
                }
            } catch (Exception ee) {
                ee.printStackTrace(); // Print stack trace if an exception occurs
            }
        }
        // If cancel button is clicked
        if (e.getSource() == bt2) {
            this.setVisible(false); // Hide current frame
        }
    }
    
    // Main method
    public static void main(String[] args) {
        new Librarian().setVisible(true); // Create an instance of Librarian and set it visible
    }
}
