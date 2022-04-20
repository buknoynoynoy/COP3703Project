package package1;
import java.sql.*;
import java.io.*;  
import java.sql.PreparedStatement;

public class StudentDatabase {
    public static void main(String[] args) throws Exception {
        //Stuff for initializing the Connection

        String userID = "T1";
        String password = "Spring2022T1";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";

        //Load the Oracle JDBC Driver
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        //Attempt connection to the Database (UNF Student Database COP3703)
        try {
            Connection conn = DriverManager.getConnection(url, userID, password);
            System.out.println(conn);
    
            boolean reachable = conn.isValid(10); //for 10 seconds
            
            //if connected is established, start the program
            if (reachable) {
                //connection was established
                System.out.println("Connection Established");
    
                SQLStudentInputs input = new SQLStudentInputs();
                //Statement stmt = conn.createStatement();
                
                //executes the statement
                //ResultSet rset = stmt.executeQuery(studentInput);

                input.getStudentInfo(); //test getStudentInfo
                String studentInput = input.inputStudent();

                System.out.println(studentInput);

                conn.close(); //close connection
            }
        } catch (SQLException e) {
            System.out.println("Couldn't Establish Connection");
        }

        //Connection conn = DriverManager.getConnection(url, userID, password);
    }
}
