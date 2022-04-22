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
                SQLCourseInputs courseInput = new SQLCourseInputs();

                //init stmt for sql statements
                Statement stmt = conn.createStatement();
                
                //executes the statement
                boolean doContinue = true;
                int proceed = -1;

                int userChoice = -1;

                //studentSQL statement
                String studentSQL;

                //departmentSQL statement
                String departmentSQL;

                //courseSQL statement
                String courseSQL;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("Welcome to the Database\nWould you like to proceed? 1 for yes -1 for no");
                do {
                    System.out.println("Continue?");
                    proceed = scan.nextInt();
                    //checks if user would like to proceed
                    if (proceed == 1) {
                        doContinue = true;
                    } else if (proceed == -1) {
                        doContinue = false;
                        break;
                    }

                    //starting the program (intro)
                    System.out.println("What would you like to input?\n1 for student.\n2 for department\n3 for course");
                    userChoice = scan.nextInt();

                    //to choose what the user wants to do (meat)
                    switch (userChoice) {

                        //input student case.
                        case 1:
                            System.out.println("Entering Student...");
                            studentInput.getStudentInfo();
                            studentSQL = studentInput.inputStudent();
                            //System.out.println(studentSQL);
                            
                            //attempt student input
                            try {
                                ResultSet studentInputs = stmt.executeQuery(studentSQL);
                            } catch (Exception ex) {
                                System.out.println("Input failed.");
                            }

                            break; //end case 1

                        //input department case
                        case 2:
                            System.out.println("Entering Department...");
                            departmentInput.getDepartmentInfo();
                            departmentSQL = departmentInput.inputDepartment();
                            //System.out.println(departmentSQL);

                            //attempt department input
                            try {
                                ResultSet departmentInputs = stmt.executeQuery(departmentSQL);
                            } catch (Exception ex) {
                                System.out.println("Input failed.");
                            }

                            break; //case 2

                        case 3:
                            System.out.println("Entering Course...");
                            courseInput.getCourseInfo();
                            courseSQL = courseInput.inputCourse();
                            System.out.println(courseSQL);

                            break;

                    } //end switch

                    System.out.println("Would you like to continue? 1 yes, -1 no:");
                    proceed = scan.nextInt();

                    //checks if user would like to proceed.
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
            //System.out.println("Couldn't Establish Connection");
            e.printStackTrace();
        }

        //Connection conn = DriverManager.getConnection(url, userID, password);
    }
}
