The library management system is a beginner-friendly project designed to develop a computerized system for efficiently managing all the daily operations of a library. It serves as an excellent learning opportunity for beginners in Java programming.

The system facilitates both students and library managers by enabling them to maintain a constant track of all the books available in the library. One of its primary features is the ability to display a comprehensive list of all available books, eliminating the need for students to wander through the entire library in search of a specific book.

Moreover, the application effectively manages user/student details, including book issuance and return records. It meticulously records the issuance date and return date for each transaction, ensuring accurate tracking of book circulation within the library.

Designed with simplicity and usability in mind, the system offers a user-friendly interface accessible to both administrators and students. Administrators have the capability to manage books seamlessly, including functionalities for adding, updating, and deleting book records. On the other hand, students can easily issue and return books using their university ID, enhancing overall efficiency and convenience.

Incorporating fundamental Java programming concepts, this project provides an ideal starting point for beginners to gain hands-on experience in Java development. It covers essential topics such as data structures, file handling, user input/output, and basic database management, thereby laying a strong foundation for further learning and exploration in the field of software development.

.>Language Used -  Java Core 
.>Concept Used - Swings, AWT, JFrame
.>(Software used) IDE Used - NetBeans [you can use any IDE]
.>Database Used - MySQ

Run this project

-For running this project , you must have installed JDK and NetBeans.[any IDE can also work]

-Create a new project using netbeans and include these files in source code folder.

 link for downloading connector: https://sourceforge.net/projects/jdbcsql/files/jdbc/mysql-connector-java-8.0.18.jar/download
 ***"package Library;

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
"*** **this is the main part of this project if it is done correctly then the entire project run without any error**

 steps to be followed :
 1.In place connectionclass.java "con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "abc");replace it with your MySQL password,remaining should be accoording to your MySQL data 


 steps in MySQL:
1.CREATE DATABASE library;       
2.USE library;
3.CREATE TABLE admin (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
4.INSERT INTO admin (username, password) VALUES ('abcd', 'abcd');"my default username and password is shown"
INSERT INTO admin (username, password) VALUES ('1234', '1234');**you can change according to your need**
INSERT INTO admin (username, password) VALUES ('fcrit', 'fcrit');

if you have any doubt regarding this project you can email  me on "jigarraina8@gmail.com"
