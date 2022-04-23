package package1;

import java.util.*;

public class SQLSectionInputs {
    Scanner scan = new Scanner(System.in);

    private String Snumber, Sinstructor, Semester, Syear, C_no;

    private boolean isValid = true;

    public void getSectionInfo() {
        
        //Enter course number
        while (isValid) {
            System.out.print("Please enter the course number (XXXXXXX): ");
            this.C_no = inputValidNum(this.C_no, 7);
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

        //enter the section number for this course (1-10)
        System.out.print("Please enter the section number for this section: ");
        this.Snumber = inputValidNum(this.Snumber, 2)

        //enter the semester this section is offered
        System.out.print("Please enter the semester this section will be offered: ");
        this.Semester = inputValidString(this.Semester, 6);

        //enter the year this will be offered
        System.out.print("Please enter the year this section will be offered: ");
        this.Syear = inputValidString(this.Syear, 4);

        //enter the instructor
        System.out.println("Who will be teaching this section?: ");
        this.Sinstructor = inputValidString(this.Sinstructor, 20);

    } //end getSectionInfo

    /**
     *  inputs section values
     * 
     * @return
     */
    public String inputSection() {

        String q = "INSERT INTO SECTION VALUES('" + Snumber + "', '" + Sinstructor + "', '" +
        Semester + "', '" + Syear + "', '" + C_no + "')";

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
