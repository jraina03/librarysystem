package Library; // Package declaration
import java.awt.event.*; // Importing necessary classes for event handling
import java.awt.*; // Importing necessary classes for GUI components
import javax.swing.*; // Importing necessary classes for Swing components
import java.sql.*; // Importing necessary classes for database interaction

// Class declaration extending JFrame and implementing ActionListener interface
public class ReturnBook extends JFrame implements ActionListener {
    JLabel l1, l2, l3; // Labels
    JButton bt1, bt2; // Buttons
    JPanel p1, p2; // Panels
    Font f, f1; // Fonts

    JTextField tf1, tf2; // TextFields

    // Constructor
    ReturnBook() {
        super("RETURN BOOK"); // Calling superclass constructor with title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setSize(650, 400); // Setting initial size
        setLocation(0, 0); // Setting initial location
        
        // Initializing fonts
        f = new Font("cooper black", Font.BOLD, 50);
        f1 = new Font("cooper black", Font.BOLD, 40);

        // Initializing labels
        l1 = new JLabel("RETURN BOOKS");
        l2 = new JLabel("BOOK NO");
        l3 = new JLabel("STUDENT ID");

        l1.setHorizontalAlignment(JLabel.CENTER); // Setting horizontal alignment for label
        l1.setForeground(Color.white); // Setting foreground color for label

        // Initializing TextFields
        tf1 = new JTextField();
        tf2 = new JTextField();

        // Initializing Buttons
        bt1 = new JButton("RETURN BOOK");
        bt2 = new JButton("CANCEL");

        // Adding ActionListener to buttons
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        // Setting fonts for labels, text fields, and buttons
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);

        bt1.setFont(f1);
        bt2.setFont(f1);

        // Initializing panels and setting layouts
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        p1.setBackground(Color.black); // Setting background color for panel

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);

        // Setting layout for the frame
        setLayout(new BorderLayout(10, 10));
        add(p1, "North"); // Adding panel to the frame's North position
        add(p2, "Center"); // Adding panel to the frame's Center position
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        // Retrieving data from text fields
        String bookno = tf1.getText();
        int stuid = Integer.parseInt(tf2.getText());

        // Action performed when the "RETURN BOOK" button is clicked
        if (e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass(); // Creating database connection object
                String q = "delete from issuebook where bookno='" + bookno + "' and studentId='" + stuid + "'"; // SQL delete query
                int res = obj.stm.executeUpdate(q); // Executing the delete query
                if (res == 0) {
                    JOptionPane.showMessageDialog(null, "BOOK IS,T ISSUE"); // Showing message if book is not issued
                    this.setVisible(false);
                } else {
                    // Updating addbook table after returning the book
                    String q1 = "update addbook set issuebook=issuebook-1 where BookNo='" + bookno + "'";
                    String q2 = "update addbook set quantity=quantity+1 where BookNo='" + bookno + "'";
                    int aaa = obj.stm.executeUpdate(q1); // Executing the update query
                    int aaaa = obj.stm.executeUpdate(q2); // Executing the update query
                    if (aaa == 1) {
                        if (aaaa == 1) {
                            JOptionPane.showMessageDialog(null, "YOUR BOOK SUCCESSFULLY UPDATED"); // Showing success message
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "PLEASE!, FILL ALL THE DETAILS CAREFULLY"); // Showing message if details are not filled properly
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "PLEASE! ,FILL ALL THE DETAILS CAREFULLY"); // Showing message if details are not filled properly
                    }
                }
            } catch (Exception ee) {
                ee.printStackTrace(); // Printing stack trace in case of exception
            }
        }
        // Action performed when the "CANCEL" button is clicked
        if (e.getSource() == bt2) {
            JOptionPane.showMessageDialog(null, "ARE YOU SURE!"); // Confirmation message
            this.setVisible(false); // Hiding the frame
        }
    }

    // Main method
    public static void main(String[] args) {
        new ReturnBook().setVisible(true); // Creating an instance of ReturnBook and setting it visible
    }
}
