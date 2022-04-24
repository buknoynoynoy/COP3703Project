package package1;
import java.sql.*;
import java.io.*;  
import java.sql.PreparedStatement;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;


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
                SQLSectionInputs sectionInput = new SQLSectionInputs();
                SQLEnrollStudent enrollStudent = new SQLEnrollStudent();

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

                //sectionSQL statement
                String sectionSQL;

                //enrollStudentSQL statement
                String enrollStudentSQL;
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
                    System.out.println("What would you like to do?\n1 to input student.\n2 to input a department.\n3 to input a course.\n4 to input a section.\n5 to display all courses for a given department.\n6 to enroll a student into a course.\n7 to add a grade to a student.");
                    userChoice = scan.nextInt();

                    //to choose what the user wants to do (meat)
                    switch (userChoice) {

                        //input student case.
                        case 1:
                            //sees if there are students in the database
                            try {
                                String countStudents = "SELECT COUNT(*) FROM STUDENT";
                                ResultSet studentCount = stmt.executeQuery(countStudents);

                                //iterate
                                while(studentCount.next()) {
                                    int numStudents = studentCount.getInt(1);
                                    if (numStudents == 0) {
                                        System.out.println("No students in database.");
                                    }
                                }

                                //print students
                                String students = "SELECT Fname, Lname, Ssn, Nnumber FROM STUDENT";
                                ResultSet printStudents = stmt.executeQuery(students);

                                //iterating through result
                                while (printStudents.next()) {

                                String Fname = printStudents.getString("Fname");
                                String Lname = printStudents.getString("Lname");
                                String Ssn = printStudents.getString("Ssn");
                                String Nnumber = printStudents.getString("Nnumber");
                                System.out.println("\nSTUDENT\n#####################################\nStudent Name: " + 
                                                    Fname + " " + Lname + "\nStudent N-Number: " + Nnumber + "\nStudent SSN: " + 
                                                    Ssn + "\n#####################################\n");

                                } //end while printStudents
    
                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end try catch

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

                            //count departments
                            try {
                                String countDeps = "SELECT COUNT(*) FROM DEPARTMENT";
                                ResultSet depCount = stmt.executeQuery(countDeps);

                                //iterate
                                while(depCount.next()) {
                                    int numDeps = depCount.getInt(1);
                                    if (numDeps == 0) {
                                        System.out.println("No departments.");
                                    }
                                }

                                //print departments
                                String deps = "SELECT Dname, Dcode, College FROM DEPARTMENT";
                                ResultSet printDeps = stmt.executeQuery(deps);

                                //iterating through result
                                while (printDeps.next()) {

                                String Dname = printDeps.getString("Dname");
                                String Dcode = printDeps.getString("Dcode");
                                String College = printDeps.getString("College");
                                System.out.println("\nDEPARTMENT\n#####################################\nDepartment Name: " + 
                                                    Dname + "\nDepartment Code: " + Dcode + "\nDepartment College: " + 
                                                    College + "\n#####################################\n");

                                } //end while printDeps
    
                            } catch (Exception e){
                                System.out.println("Failed.");
                            } //end try catch

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
                        
                        //input course case
                        case 3:

                            try {
                                //printing departments
                                String deps = "SELECT Dname, Dcode, College FROM DEPARTMENT";
                                ResultSet printDeps = stmt.executeQuery(deps);

                                //iterating through result
                                while (printDeps.next()) {

                                String Dname = printDeps.getString("Dname");
                                String Dcode = printDeps.getString("Dcode");
                                String College = printDeps.getString("College");
                                System.out.println("\nDEPARTMENT\n#####################################\nDepartment Name: " + 
                                                    Dname + "\nDepartment Code: " + Dcode + "\nDepartment College: " + 
                                                    College + "\n#####################################\n");

                                } //end while printDeps

                            } catch (Exception e) {
                                System.out.println("Failed.");
                                break;
                            } //end printing departments.

                            //print courses...
                            System.out.println("Printing courses...");
                            try {
                                String courses = "SELECT Dname, CName, Cnumber, Cdesc FROM DEPARTMENT, COURSE WHERE Dcode = Depart_Code";
                                ResultSet printCourses = stmt.executeQuery(courses);

                                //print courses
                                while (printCourses.next()) {
                                    String Dname = printCourses.getString("Dname");
                                    String CName = printCourses.getString("CName");
                                    String Cnumber = printCourses.getString("Cnumber");
                                    String Cdesc = printCourses.getString("Cdesc");
                                    System.out.println("\nCOURSE\n#####################################\nDepartment: " + Dname + "\nCourse Name: " + 
                                    CName + "\nCourse number: " + Cnumber + "\nCourse description: " + 
                                    Cdesc + "\n#####################################\n");
                                } //end while printCourses

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end print courses

                            System.out.println("Entering Course...");
                            courseInput.getCourseInfo();
                            courseSQL = courseInput.inputCourse();
                            //System.out.println(courseSQL);

                            //execute statement
                            try {
                                ResultSet courseInputs = stmt.executeQuery(courseSQL);
                            } catch (Exception ex) {
                                System.out.println("Input failed.");
                            }

                            break; //case 3

                        case 4:

                            //print courses...
                            System.out.println("Printing courses...");
                            try {
                                String courses = "SELECT Dname, CName, Cnumber, Cdesc FROM DEPARTMENT, COURSE WHERE Dcode = Depart_Code";
                                ResultSet printCourses = stmt.executeQuery(courses);

                                //print courses
                                while (printCourses.next()) {
                                    String Dname = printCourses.getString("Dname");
                                    String CName = printCourses.getString("CName");
                                    String Cnumber = printCourses.getString("Cnumber");
                                    String Cdesc = printCourses.getString("Cdesc");
                                    System.out.println("\nCOURSE\n#####################################\nDepartment: " + Dname + "\nCourse Name: " + 
                                    CName + "\nCourse number: " + Cnumber + "\nCourse description: " + 
                                    Cdesc + "\n#####################################\n");
                                } //end while printCourses

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end print courses

                            System.out.println("Entering Section...");
                            sectionInput.getSectionInfo();
                            sectionSQL = sectionInput.inputSection();
                            //System.out.println(sectionSQL);

                            try {
                                ResultSet sectionInputs = stmt.executeQuery(sectionSQL);
                            } catch (Exception ex) {
                                System.out.println("Input failed.");
                            }

                            break; //case 4

                        case 5:
                            boolean isValid = true;
                            String courseFromDep;
                            //printing departments
                            System.out.println("Displaying current Departments...");
                            try {
                                String deps = "SELECT Dname, Dcode, College FROM DEPARTMENT";
                                ResultSet printDeps = stmt.executeQuery(deps);

                                //iterating through result
                                while (printDeps.next()) {

                                String Dname = printDeps.getString("Dname");
                                String Dcode = printDeps.getString("Dcode");
                                String College = printDeps.getString("College");
                                System.out.println("#####################################\nDepartment Name: " + 
                                                    Dname + "\nDepartment Code: " + Dcode + "\nDepartment College: " + 
                                                    College + "\n#####################################\n");

                                } //end while printDeps

                            } catch (Exception e) {
                                System.out.println("Failed.");
                                break;
                            } //end printing departments.

                            //get the department code
                            while (isValid) {

                                System.out.print("\nChoose the department to display sections, type the department code (XXXX): ");
                                courseFromDep = scan.nextLine();
                                isValid = (isNumeric(courseFromDep));

                                if (!isValid) {
                                    System.out.println("Invalid Input. Numbers only. Please try again.");
                                    isValid = true;
                                } else if (courseFromDep.length() > 4 || courseFromDep.length() < 4) {
                                    System.out.println("Invalid Input. Please try again.");
                                    isValid = true;
                                } else {
                                    //print the courses
                                    System.out.println("\nPrinting courses...");
                                    try {
                                        String courses = "SELECT Dname, CName, Cnumber, Cdesc FROM DEPARTMENT, COURSE WHERE (Dcode = Depart_Code AND Depart_Code='" + courseFromDep + "')";
                                        ResultSet printCourses = stmt.executeQuery(courses);

                                        //iterate through results
                                        while (printCourses.next()) {
                                            String Dname = printCourses.getString("Dname");
                                            String CName = printCourses.getString("CName");
                                            String Cnumber = printCourses.getString("Cnumber");
                                            String Cdesc = printCourses.getString("Cdesc");
                                            System.out.println("\nCOURSE\n#####################################\nDepartment: " + Dname + "\nCourse Name: " + 
                                            CName + "\nCourse number: " + Cnumber + "\nCourse description: " + 
                                            Cdesc + "\n#####################################\n");
                                        } //end while printCourses

                                    } catch (Exception e) {
                                        System.out.println("Failed.");
                                    } //end print courses

                                    break;
                                }
                            }
                            isValid = true;

                            break; //case 5
                            
                        case 6:
                            //sees if there are students in the database
                            try {
                                String countStudents = "SELECT COUNT(*) FROM STUDENT";
                                ResultSet studentCount = stmt.executeQuery(countStudents);

                                //iterate
                                while(studentCount.next()) {
                                    int numStudents = studentCount.getInt(1);
                                    if (numStudents == 0) {
                                        System.out.println("No students in database.");
                                    }
                                }

                                //print students
                                String students = "SELECT Fname, Lname, Ssn, Nnumber FROM STUDENT";
                                ResultSet printStudents = stmt.executeQuery(students);

                                //iterating through result
                                while (printStudents.next()) {

                                String Fname = printStudents.getString("Fname");
                                String Lname = printStudents.getString("Lname");
                                String Ssn = printStudents.getString("Ssn");
                                String Nnumber = printStudents.getString("Nnumber");
                                System.out.println("\nSTUDENT\n#####################################\nStudent Name: " + 
                                                    Fname + " " + Lname + "\nStudent N-Number: " + Nnumber + "\nStudent SSN: " + 
                                                    Ssn + "\n#####################################\n");

                                } //end while printStudents

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end try catch

                            //gets the student's Nnumber
                            enrollStudent.getStudentNumber();

                            String studentName = "SELECT Fname, Lname FROM STUDENT WHERE (Nnumber='" + enrollStudent.N_no + "')";
                            ResultSet studentChosen = stmt.executeQuery(studentName);

                            //display who is being enrolled
                            while (studentChosen.next()) {
                                String Fname = studentChosen.getString("Fname");
                                String Lname = studentChosen.getString("Lname");

                                System.out.println("\nEnrolling: " + Fname + " " + Lname);
                            }

                            //print courses...
                            System.out.println("Printing courses...");
                            try {
                                String courses = "SELECT CName, Cnumber, Cdesc FROM DEPARTMENT, COURSE WHERE Dcode = Depart_Code";
                                ResultSet printCourses = stmt.executeQuery(courses);

                                //print courses
                                while (printCourses.next()) {
                                    String CName = printCourses.getString("CName");
                                    String Cnumber = printCourses.getString("Cnumber");
                                    String Cdesc = printCourses.getString("Cdesc");
                                    System.out.println("\nCOURSE\n#####################################\nCourse Name: " + 
                                    CName + "\nCourse number: " + Cnumber + "\nCourse description: " + 
                                    Cdesc + "\n#####################################\n");
                                } //end while printCourses

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end print courses

                            //get student course number
                            enrollStudent.getCourseNumber();

                            String courseName = "SELECT Cname, Cnumber FROM COURSE WHERE (Cnumber='" + enrollStudent.C_no + "')";
                            ResultSet courseChosen = stmt.executeQuery(courseName);

                            //display course
                            while (courseChosen.next()) {
                                String Cname = courseChosen.getString("Cname");
                                String Cnumber = courseChosen.getString("Cnumber");

                                System.out.println("\nEnrolling into: " + Cname + " C-Number: " + Cnumber);
                            } //end while

                            //print sections for this course
                            System.out.println("Printing sections...");
                            try {
                                String sections = "SELECT Snumber, Sinstructor FROM SECTION, COURSE WHERE (Cnumber = C_no AND C_no = '" + enrollStudent.C_no + "')";
                                ResultSet printSections = stmt.executeQuery(sections);

                                //print sections
                                while (printSections.next()) {
                                    String Snumber = printSections.getString("Snumber");
                                    String Sinstructor = printSections.getString("Sinstructor");
                                    System.out.println("\nSECTION\n#####################################\nSection number: " + 
                                    Snumber + "\nSection Instructor: " + Sinstructor + "\n#####################################\n");
                                } //end while printSections

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end printSections

                            //GET SECTION INFO
                            enrollStudent.getSectionNumber();

                            enrollStudentSQL = enrollStudent.enrollStudent();
                            //System.out.println(enrollStudentSQL);

                            try {
                                ResultSet studentEnrolled = stmt.executeQuery(enrollStudentSQL);
                            } catch (Exception ex) {
                                System.out.println("Input failed.");
                            }


                            break; //case 6
                        case 7:

                            //sees if there are students in the database
                            try {
                                String countStudents = "SELECT COUNT(*) FROM STUDENT";
                                ResultSet studentCount = stmt.executeQuery(countStudents);

                                //iterate
                                while(studentCount.next()) {
                                    int numStudents = studentCount.getInt(1);
                                    if (numStudents == 0) {
                                        System.out.println("No students in database.");
                                    }
                                }

                                //print students
                                String students = "SELECT Fname, Lname, Ssn, Nnumber FROM STUDENT";
                                ResultSet printStudents = stmt.executeQuery(students);

                                //iterating through result
                                while (printStudents.next()) {

                                String Fname = printStudents.getString("Fname");
                                String Lname = printStudents.getString("Lname");
                                String Ssn = printStudents.getString("Ssn");
                                String Nnumber = printStudents.getString("Nnumber");
                                System.out.println("\nSTUDENT\n#####################################\nStudent Name: " + 
                                                    Fname + " " + Lname + "\nStudent N-Number: " + Nnumber + "\nStudent SSN: " + 
                                                    Ssn + "\n#####################################\n");

                                } //end while printStudents

                            } catch (Exception e) {
                                System.out.println("Failed.");
                            } //end try catch

                            System.out.println("Enter the N-number of the student you'd like to add a grade to.");
                            enrollStudent.getStudentNumber();

                            studentName = "SELECT Fname, Lname FROM STUDENT WHERE (Nnumber='" + enrollStudent.N_no + "')";
                            studentChosen = stmt.executeQuery(studentName);

                            //display who is being enrolled
                            while (studentChosen.next()) {
                                String Fname = studentChosen.getString("Fname");
                                String Lname = studentChosen.getString("Lname");

                                System.out.println("\nEnrolling: " + Fname + " " + Lname);
                            }

                            //display sections student is in
                            String enrollments = "SELECT CName, Snumber, Sinstructor FROM COURSE, SECTION, ENROLLED_IN WHERE (COURSE.Cnumber=ENROLLED_IN.C_no AND SECTION.Snumber=ENROLLED_IN.S_no AND ENROLLED_IN.N_no = '" + enrollStudent.N_no + "')";
                            ResultSet sectionEnrollments = stmt.executeQuery(enrollments);
                            while (sectionEnrollments.next()) {
                                String Cname = sectionEnrollments.getString("Cname");
                                String Snumber = sectionEnrollments.getString("Snumber");
                                String Sinstructor = sectionEnrollments.getString("Sinstructor");

                                System.out.println("\nSECTION\n#####################################\nCourse Name: " + 
                                                    Cname + "\nSection Number: " + Snumber + "\nInstructor: " + 
                                                    Sinstructor + "\n#####################################\n");
                            }

                            //prompts for section number 
                            System.out.println("Please enter the section you would like to add a grade to.");
                            enrollStudent.getSectionNumber();

                            //prompts for the grade of the student in that course.
                            enrollStudent.getStudentGrade();

                            String graded = enrollStudent.addGrade();

                            try {
                                ResultSet addGrade = stmt.executeQuery(graded);
                            } catch (Exception e) {
                                System.out.println("Input Failed.");
                            }

                            break;
                            

                    } //end switch

                    System.out.println("\nWould you like to continue? 1 yes, -1 no:");
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
    } //end main

    public static String getString() {
        try {
            StringBuffer buffer = new StringBuffer();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
              buffer.append((char)c);
              c = System.in.read();
              }
            return buffer.toString().trim();
            }
            catch (IOException e){return "";}

    } //end getString()

    public static int getInt() {
        String s= getString();
        return Integer.parseInt(s);

    } //end getInt()

        /**
     * checks if the string parameter is numeric.
     * 
     * @param s user string
     * @return  returns true or false depending on if numeric
     */
    public static boolean isNumeric (String s) {
        try {
            Double.parseDouble(s);
            return true;

        } catch (NumberFormatException ex) {
            return false;

        } //end try-catch

    } //end isNumeric()
}
