package package1;
import java.sql.*;
import java.io.*;  
import java.sql.PreparedStatement;
import java.util.*;


public class StudentDatabase {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
                SQLStudentInputs studentInput = new SQLStudentInputs();
                SQLDepartmentInputs departmentInput = new SQLDepartmentInputs();

                //init stmt for sql statements
                Statement stmt = conn.createStatement();
                
                //executes the statement
                //ResultSet rset = stmt.executeQuery(studentInput);
                boolean doContinue = true;
                int proceed = -1;

                int userChoice = -1;

                //studentSQL statement
                String studentSQL;

                //departmentSQL statement
                String departmentSQL;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                do {
                    System.out.println("Welcome to the Database\nWould you like to proceed? 1 for yes -1 for no");
                    proceed = scan.nextInt();

                    if (proceed == 1) {
                        doContinue = true;
                    } else if (proceed == -1) {
                        doContinue = false;
                        break;
                    }

                    //starting the program
                    System.out.println("What would you like to input?\n1 for student.\n2 for department");
                    userChoice = scan.nextInt();

                    //to choose what the user wants to do
                    switch (userChoice) {

                        //input student case.
                        case 1:
                            System.out.println("Entering Student...");
                            studentInput.getStudentInfo();
                            studentSQL = studentInput.inputStudent();
                            System.out.println(studentSQL);

                            break;
                        case 2:
                            System.out.println("Entering Database");
                            departmentInput.getDepartmentInfo();
                            departmentSQL = departmentInput.inputDatabase();
                            System.out.println(departmentSQL);

                            break;
                    }

                    System.out.println("Would you like to continue? 1 yes, -1 no:");
                    proceed = scan.nextInt();
                    if (proceed == 1) {
                        doContinue = true;
                    } else if (proceed == -1) {
                        doContinue = false;
                        break;
                    }

                } while (doContinue);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                conn.close(); //close connection
            }
        } catch (SQLException e) {
            System.out.println("Couldn't Establish Connection");
        }

        //Connection conn = DriverManager.getConnection(url, userID, password);
    }
}
