package package1;
import java.util.*;

public class SQLEnrollStudent extends Object {
    Scanner scan = new Scanner(System.in);

    private boolean isValid = true;

    protected String N_no, S_no, C_no, Grade;

    public void getStudentNumber() {

        //Enter Student's Nnumber
        while (isValid) {
            System.out.print("Enter the N-number of the student you would like to enroll into a class: ");
            this.N_no = scan.nextLine();
            isValid = (isNumeric(this.N_no));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.N_no.length() > 9 || this.N_no.length() < 9) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                if (Character.toString(this.N_no.charAt(0)).equals("n")) {
                    this.N_no = this.N_no.replace("n", "N");
                }
            }
        }
        isValid = true;

    } //end getStudentNumber()

    public void getCourseNumber() {

        //Enter course number
        while (isValid) {
            System.out.print("Please enter the course number (XXXXXXX): ");
            this.C_no = scan.nextLine();
            isValid = (isNumeric(this.C_no));

            if (!isValid) {
                System.out.println("Invalid Input. Numbers only. Please try again.");
                isValid = true;
            } else if (this.C_no.length() > 7 || this.C_no.length() < 7) {
                System.out.println("Invalid Input. Minimum and maximum of 7 numbers. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

    } //end getCourseNumber

    public void getSectionNumber() {

        //input Snumber
        System.out.print("Please enter the section number for the section you would liek to enroll the student into: ");
        this.S_no = inputValidNum(this.S_no, 2);

    } //end getSectionNumber()

    public void getStudentGrade() {

        //get grade
        System.out.print("Please enter the student's grade: ");
        this.Grade = inputValidString(this.Grade, 1);

    } //end getStudentGrade()
    

    public String enrollStudent() {
        String q = "INSERT INTO ENROLLED_IN VALUES('" + N_no + "', '" + S_no + "', '" +
        C_no + "', '"  + Grade + "')";

        return q;
    } //end enrollStudent()

    public String addGrade() {

        String q = "UPDATE ENROLLED_IN SET Grade = '" + Grade + "'  WHERE (N_no = '" + N_no + "' AND S_no = '" + S_no  + "')";

        return q;
    } //end addGrade()

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
