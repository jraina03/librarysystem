package Library; // Package declaration

import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components

// Class declaration extending JFrame and implementing ActionListener
public class index extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4; // Declaring JLabels
    JButton bt1, bt2; // Declaring JButtons
    JPanel p1, p2, p3; // Declaring JPanels
    Font f, f1; // Declaring Fonts

    // Constructor
    index() {
        super("LOGIN PAGE"); // Calling superclass constructor
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setLocation(500, 350); // Setting initial location
        setSize(500, 200); // Setting initial size

        // Initializing fonts
        f = new Font("cooper black", Font.BOLD, 50);
        f1 = new Font("cooper black", Font.BOLD, 60);
        
        // Initializing JLabels with text
        l1 = new JLabel("ADMIN ");
        l2 = new JLabel("LIBRARIAN ");
        l3 = new JLabel(" LIBRARY  MANAGEMENT SYSTEM");
        
        // Initializing JButtons with text
        bt1 = new JButton("LOGIN");
        bt2 = new JButton("LOGIN");
        
        // Adding ActionListener to buttons
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        // Loading image for JLabel
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/icon/login.png"));
        Image i = img.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(i);
        l4 = new JLabel(img2);
        
        // Setting fonts for labels and buttons
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f);
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        // Setting alignment and foreground color for label l3
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.white);
        
        // Initializing JPanel p1 with GridLayout
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 10, 10));
        p1.add(l1);
        p1.add(bt1);
        p1.add(l2);
        p1.add(bt2);
        
        // Initializing JPanel p2 with GridLayout and adding label l4
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l4);
        
        // Initializing JPanel p3 with GridLayout and adding label l3, setting background color
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l3);
        p3.setBackground(Color.black);
        
        // Setting layout of JFrame and adding panels
        setLayout(new BorderLayout(10, 10));
        add(p3, "North");
        add(p2, "West");
        add(p1, "Center");
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        // Action performed when bt1 is clicked
        if (e.getSource() == bt1) {
            System.out.println("Admin Login");
            new Admin().setVisible(true); // Opening Admin window
            this.setVisible(false); // Hiding current window
        }
        // Action performed when bt2 is clicked
        if (e.getSource() == bt2) {
            System.out.println("Librarian Login");
            new Librarian().setVisible(true); // Opening Librarian window
            this.setVisible(false); // Hiding current window
        }
    }

    // Main method
    public static void main(String[] args) {
        new index().setVisible(true); // Creating an instance of index and setting it visible
    }
}
