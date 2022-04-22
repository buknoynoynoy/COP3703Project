package package1;

import java.util.*;

import javax.print.attribute.SupportedValuesAttribute;

public class SQLCourseInputs {

    Scanner scan = new Scanner(System.in);

    private String Cnumber, CName, Cdesc, Chours, Clevel, Depart_Code;

    private boolean isValid = true;

    public void getCourseInfo() {

        //enter department for course
        while (isValid) {
            System.out.print("What department will this course be in: ");
            this.Depart_Code = scan.nextLine();
            isValid = (isNumeric(this.Depart_Code));

            if (!isValid) {
                System.out.println("Invalid Input. Numbers only. Please try again.");
                isValid = true;
            } else if (this.Depart_Code.length() > 4 || this.Depart_Code.length() < 4) {
                System.out.println("Invalid Input. Minimum 4 numbers. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        //Enter course name
        System.out.print("Please enter the course name: ");
        this.CName = inputValidString(this.CName, 20);

        //Enter course number
        System.out.print("Please enter the course number (XXXXXXX): ");
        this.Cnumber = inputValidNum(this.Cnumber, 7);

        //enter course description
        System.out.print("Please enter the course description: ");
        this.Cdesc = inputValidString(this.Cdesc, 100);

        //enter course hours
        System.out.print("Please enter the number of hours for this course: ");
        this.Chours = inputValidNum(this.Chours, 1);

        //enter course level
        System.out.print("Please enter the course level: ");
        this.Clevel = inputValidString(this.Clevel, 10);

    } //end getCourseInfo()

    /**
     *  inputs course values
     * 
     * @return
     */
    public String inputCourse() {

        String q = "INSERT INTO COURSE VALUES('" + Cnumber + "', '" + CName + "', '" +
        Cdesc + "', '" + Chours + "', '" + Clevel + "', '" + Depart_Code + "')";

        return q;
    }

    /**
     *  check if string is valid
     * 
     * @param in
     * @param check
     */
    public String inputValidString(String in, int check) {
        while (isValid) {

            in = scan.nextLine();
            isValid = (isNumeric(in));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (in.length() > check) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        return in;
    } //end checkValidString()

    public String inputValidNum(String in, int check) {
        while (isValid) {

            in = scan.nextLine();
            isValid = (isNumeric(in));

            if (!isValid) {
                System.out.println("Invalid Input. Numbers only. Please try again.");
                isValid = true;
            } else if (in.length() > check) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;
        return in;
    } //end inputValidNum()

    /**
     * checks if the string parameter is numeric.
     * 
     * @param s user string
     * @return  returns true or false depending on if numeric
     */
    public boolean isNumeric (String s) {
        try {
            Double.parseDouble(s);
            return true;

        } catch (NumberFormatException ex) {
            return false;

        } //end try-catch

    } //end isNumeric()
    
}
