package Library; // Package declaration for the Library package

import java.awt.event.*; // Importing classes related to AWT event handling
import java.awt.*; // Importing AWT classes
import javax.swing.*; // Importing Swing classes

// Class declaration for AdminSection, extending JFrame and implementing ActionListener interface
public class AdminSection extends JFrame implements ActionListener {
    JLabel l1; // Declaration of JLabel variable
    Font f, f1; // Declaration of Font variables

    // Constructor for AdminSection class
    AdminSection() {
        super("ADMIN PAGE"); // Calling superclass constructor with window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Setting window to maximized state
        setLocation(450, 400); // Setting initial location of the window
        setSize(1500, 800); // Setting initial size of the window

        f = new Font("cooper black", Font.BOLD, 50); // Creating Font object for title
        f1 = new Font("cooper black", Font.BOLD, 40); // Creating Font object for menu items

        // Loading and scaling image for the JLabel
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/laptop.jpg"));
        Image img = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1); // Creating JLabel with scaled image

        // Creating menu bar and menus
        JMenuBar m1 = new JMenuBar(); // Creating menu bar
        JMenu men1 = new JMenu("ADD INFO"); // Creating "ADD INFO" menu
        JMenuItem ment1 = new JMenuItem("Add Librarian"); // Creating "Add Librarian" menu item

        JMenu men2 = new JMenu("VIEW INFO"); // Creating "VIEW INFO" menu
        JMenuItem ment2 = new JMenuItem("View Librarian"); // Creating "View Librarian" menu item

        JMenu men3 = new JMenu("DELETE INFO"); // Creating "DELETE INFO" menu
        JMenuItem ment3 = new JMenuItem("Delete Librarian"); // Creating "Delete Librarian" menu item

        JMenu men4 = new JMenu("EXIT"); // Creating "EXIT" menu
        JMenuItem ment4 = new JMenuItem("Logout"); // Creating "Logout" menu item

        // Adding menu items to respective menus
        men1.add(ment1);
        men2.add(ment2);
        men3.add(ment3);
        men4.add(ment4);

        // Adding menus to the menu bar
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);

        // Setting fonts for menus and menu items
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);

        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);

        // Adding action listeners to menu items
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);

        // Setting menu bar for the frame
        setJMenuBar(m1);
        // Adding JLabel to the frame
        add(l1);
    }

    // Method to handle actionPerformed event
    public void actionPerformed(ActionEvent e) {
        String comnd = e.getActionCommand(); // Getting action command

        // Checking which menu item was clicked and performing respective actions
        if (comnd.equals("Add Librarian")) {
            new AddLibrarian().setVisible(true); // Open AddLibrarian window
        } else if (comnd.equals("View Librarian")) {
            System.out.println("View Librarian"); // Print message to console
            new ViewLibrarian().setVisible(true); // Open ViewLibrarian window
        } else if (comnd.equals("Delete Librarian")) {
            System.out.println("Delete Librarian"); // Print message to console
            new DeleteLibrarian().setVisible(true); // Open DeleteLibrarian window
        } else if (comnd.equals("Logout")) {
            this.setVisible(false); // Hide the current AdminSection window
            new index().setVisible(true); // Create and display the index page
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new AdminSection().setVisible(true); // Creating and displaying AdminSection window
    }
}
