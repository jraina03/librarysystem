package Library; // Package declaration
import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components
import java.sql.*; // Importing necessary classes for database interaction

// Class declaration extending JFrame and implementing ActionListener interface
public class LibrarianSection extends JFrame implements ActionListener {
    JLabel l1; // Label
    JButton bt1; // Button
    JPanel p1, p2; // Panels
    Font f, f1; // Fonts
    
    // Constructor
    LibrarianSection() {
        super("LIBRARIAN SECTION"); // Calling superclass constructor with title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setLocation(450, 400); // Setting initial location
        setSize(1500, 800); // Setting initial size
        
        // Initializing fonts
        f = new Font("cooper black", Font.BOLD, 50);
        f1 = new Font("cooper black", Font.BOLD, 40);
        
        // Loading and scaling the image for the background
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/home 2.jpg"));
        Image img = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1); // Initializing label with the scaled image
        
        // Creating menu bar and menu items
        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("ADD INFO");
        JMenuItem ment1 = new JMenuItem("Add Book");
        JMenu men2 = new JMenu("VIEW INFO");
        JMenuItem ment2 = new JMenuItem("View Book");
        JMenuItem ment3 = new JMenuItem("View Issue Book");
        JMenu men3 = new JMenu("ISSUE INFO");
        JMenuItem ment4 = new JMenuItem("Issue Book");
        JMenu men4 = new JMenu("RETURN");
        JMenuItem ment5 = new JMenuItem("Return Book");
        JMenu men5 = new JMenu("EXIT");
        JMenuItem ment6 = new JMenuItem("Log out");
        
        // Adding menu items to the menu
        men1.add(ment1);
        men2.add(ment2);
        men2.add(ment3);
        men3.add(ment4);
        men4.add(ment5);
        men5.add(ment6);
        
        // Setting fonts for menus and menu items
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        
        // Adding ActionListener to menu items
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        
        // Adding menu to the menu bar
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        
        // Setting the menu bar for the frame
        setJMenuBar(m1);
        
        // Adding the background label to the frame
        add(l1);
    }
    
    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        String comnd = e.getActionCommand();
        if (comnd.equals("Add Book")) {
            new AddBook().setVisible(true); // Opening AddBook frame
        } else if (comnd.equals("View Book")) {
            new ViewBook().setVisible(true); // Opening ViewBook frame
        } else if (comnd.equals("View Issue Book")) {
            // new ViewIssueBook().setVisible(true); // Open ViewIssueBook frame
        } else if (comnd.equals("Issue Book")) {
            new IssueBook().setVisible(true); // Open IssueBook frame
        } else if (comnd.equals("Return Book")) {
            new ReturnBook().setVisible(true); // Open ReturnBook frame
        } else if (comnd.equals("Logout")) {
            System.exit(0); // Exit the application
        }
    }
   
    // Main method
    public static void main(String[] args) {
        new LibrarianSection().setVisible(true); // Creating an instance of LibrarianSection and setting it visible
    }
}
