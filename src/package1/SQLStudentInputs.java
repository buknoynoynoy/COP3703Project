package package1;
import java.sql.*;
import java.io.*;
import java.util.*;

import javax.script.AbstractScriptEngine;
import javax.sound.midi.SysexMessage;

public class SQLStudentInputs extends StudentDatabase {

    Scanner scan = new Scanner(System.in);

    private static boolean isValid = true;

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

        String sameAddress;
        
        //int ssnLength = 0;

        //Enter student's Name
        getStudentName();
        isValid = true;

        //Enter student's SSN
        System.out.println("Please enter the student's SSN: ");
        this.Ssn = scan.nextLine();


        //Enter Student's Nnumber
        System.out.print("\nPlease enter the students N-Number in this format (N--------): ");
        this.Nnumber = scan.nextLine();
        if (Character.toString(this.Nnumber.charAt(0)).equals("n")) {
            this.Nnumber = this.Nnumber.replace("n", "N");
        }

        //Enter student's Bdate
        System.out.println("\nEnter the student's Birthday (YYYY-MM-DD): ");
        this.Bdate = scan.nextLine();

        //Enter the student's Gender
        while (isValid) {
            System.out.print("\nPlease enter your gender (Male or Female): ");
            this.Sex = scan.nextLine();
            isValid = (isNumeric(this.Sex));

            if (isValid) {
                System.out.println("Invalid Input. Please Try Again.");

            } else {
                this.Sex = Character.toString(this.Sex.charAt(0));
                //isValid = false;
            } //end if
        } //end while
        isValid = true;

        //enter their class
        while (isValid) {
            System.out.print("\nEnter your student's class (Freshman, Sophomore, Junior, or Senior): ");
            this.sClass = scan.nextLine();
            isValid = (isNumeric(this.sClass));

            if (isValid || this.sClass.length() > 10) {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        isValid = true;


        //Enter student's degree
        System.out.print("\nEnter your student's degree (BA, BS, PHD): ");
        this.Degree = scan.nextLine();

        //Enter student's current phone address
        System.out.print("\nPlease enter the student's current phone number: ");
        this.Cphone = scan.nextLine();

        //Enter student's current city
        System.out.print("\nEnter the current city: ");
        this.Ccity = scan.nextLine();

        //Enter student's current state
        System.out.print("\nEnter the current state: ");
        this.Cstate = scan.nextLine();

        //Enter the student's current zip
        System.out.print("\nEnter the student's current zip: ");
        this.Czip = scan.nextLine();

        System.out.print("\nAre these the same as your permanent address? 1 for yes -1 for no: ");
        sameAddress = scan.nextLine();

        if (sameAddress.equals("1")) {
            this.Pphone = this.Cphone;
            this.Pcity = this.Ccity;
            this.Pstate = this.Cstate;
            this.Pzip = this.Czip;

        } else if (sameAddress.equals("-1")) {
            System.out.print("\nEnter your permanent phone: ");
            this.Pphone = scan.nextLine();

            System.out.print("\nEnter your permanent city: ");
            this.Pcity = scan.nextLine();

            System.out.print("\nEnter your permanent state: ");
            this.Pstate = scan.nextLine();

            System.out.print("\nEnter your permanent zip: ");
            this.Pzip = scan.nextLine();
        }

    } //end getStudentInfo()

    /**
     * Acquires the name of the student.
     */
    public void getStudentName() {

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
                        //if input has too many names run this
                        System.out.println("Invalid Input. Please Enter in this format: FirstName MiddleName LastName");
                        isValid = true;
                } //end if else

            } //end main if statement (for name)

        } //end while
        isValid = true;
    } //end getStudentName();

    /**
     * Creates a string for the sql statement from the user input. Dependent on getStudentInfo()
     * 
     * @return      string with the values and sql statement stuff.
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
     * Checks to see if a string is numeric or not
     * 
     * @param s     string input for checking
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
