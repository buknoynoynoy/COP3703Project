package package1;
import java.sql.*;
import java.io.*;
import java.util.*;

import javax.swing.event.SwingPropertyChangeSupport;

public class SQLInputs extends StudentDatabase {

    private String Full_Name;
    private String Fname;
    private String Minit;
    private String Lname;
    private String Ssn;
    private String Nnumber;
    private String Bdate;
    private String Sex;
    private String sClass;
    private String Degree;
    private String Cphone;
    private String Ccity;
    private String Cstate;
    private String Czip;
    private String Pphone;
    private String Pcity;
    private String Pstate;
    private String Pzip;

    public void getStudentInfo() {

        Scanner scan = new Scanner(System.in);
        boolean isValid = true;

        /**
         * prompts for student name information
         */
        while (isValid) {
            System.out.print("Enter your student's name: ");
            this.Full_Name = scan.nextLine();
            isValid = isNumeric(this.Full_Name);

            if (isValid) {
                System.out.println("Invalid Input, please try again.\n");

            } else {

                int spaceCount = this.Full_Name.split(" ").length - 1;

                if ((spaceCount < 3) && (spaceCount > 0)) {
                    /**
                     * separate into fname, minit, and lname
                     * */
                    System.out.println(this.Full_Name + "\n");
                    int cut = this.Full_Name.indexOf(" ");
                    this.Fname = this.Full_Name.substring(0, cut);
                    //System.out.println(this.Fname);
                    
                    if (spaceCount == 2) {
                        this.Full_Name = this.Full_Name.substring(cut + 1);
                        cut = this.Full_Name.indexOf(" ");
                        this.Minit = this.Full_Name.substring(0, cut);
                        this.Minit = Character.toString(this.Minit.charAt(0));
                        //System.out.println(this.Minit);
                        
                    } //end if statement
        
                    this.Lname = this.Full_Name.substring(cut + 1);
                    //System.out.println(this.Lname);

                } else {
                    System.out.println("Invalid Input. Please Enter in this format: FirstName MiddleName LastName");
                    isValid = true;
                }

            }
        
        } //end while

        //System.out.println("Fname is: " + this.Fname);
    
    } //end getStudentInfo()

    /**
     * 
     * @return
     */
    public String inputStudent() {

        //creates insert statement for student
        String q = "INSERT INTO STUDENT VALUES('" + Fname + "', '" + Minit +
        "', '" + Lname + "', '" + Ssn + "', '" + Nnumber + "', TO_DATE('" +
        Bdate + "', 'YYYY-MM-DD'), '" + Sex + "', '" + sClass + "', '" + Degree + "', '" +
        Cphone + "', '" + Ccity + "', '" + Cstate + "', '" + Czip + "', '" +
        Pphone + "', '" + Pcity + "', '" + Pstate + "', '" + Pzip + "')";

         return q;
    } //end inputStudent()

    /**
     * 
     * @param s     string input
     * @return      returns boolean true or false depending on if input is numeric
     */
    public boolean isNumeric (String s) {
        try {
            Double.parseDouble(s);
            return true;

        } catch (NumberFormatException ex) {
            return false;

        } //end try-catch

    } //end isNumeric()

} //end class
