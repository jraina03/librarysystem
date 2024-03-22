package Library;

import java.sql.*;

public class ConnectionClass {
    Connection con; // Connection object
    Statement stm; // Statement object

    // Constructor to establish database connection
    ConnectionClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "abc");
            stm = con.createStatement(); // Create a statement object
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }

    // Main method for testing the ConnectionClass
    public static void main(String[] args) {
        new ConnectionClass(); // Create an instance of ConnectionClass
    }
}
