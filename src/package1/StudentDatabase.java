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
    
            if (reachable) {
                System.out.println("Connection Established");
    
                SQLInputs input = new SQLInputs();
                Statement stmt = conn.createStatement();

                String Fname = "Vincent";
                String Minit = "R";
                String Lname = "Almeda";
                String Ssn = "987654321";
                String Nnumber = "N12345678";
                String Bdate = "2002-07-08";
                String Sex = "M";
                String sClass = "Sophomore";
                String Degree = "BA";
                String Cphone = "5202225866";
                String Ccity = "Saint Johns";
                String Cstate = "Florida";
                String Czip = "32259";
                String Pphone = "5202225866";
                String Pcity = "Saint Johns";
                String Pstate = "Florida";
                String Pzip = "32259";
                String studentInput = input.inputStudent(Fname, Minit, Lname, Ssn, Nnumber, Bdate, Sex, sClass, Degree, Cphone, Ccity, Cstate, Czip, Pphone, Pcity, Pstate, Pzip);
                
                System.out.println(studentInput);

                ResultSet rset = stmt.executeQuery(studentInput);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Connection conn = DriverManager.getConnection(url, userID, password);
    }
}
