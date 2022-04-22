package package1;

import java.util.*;

public class SQLDepartmentInputs extends Object {

    Scanner scan = new Scanner(System.in);

    private boolean isValid = true;

    private String Dcode;
    private String DName;
    private String Office_No;
    private String Office_Phone;
    private String College;

    public void getDepartmentInfo() {

        //get the department name
        while (isValid) {

            System.out.print("\nPlease enter the Department name: ");
            this.DName = scan.nextLine();
            isValid = (isNumeric(this.DName));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.DName.length() > 15) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        //get the department code
        while (isValid) {

            System.out.print("\nPlease enter the Department code (XXXX): ");
            this.Dcode = scan.nextLine();
            isValid = (isNumeric(this.Dcode));

            if (!isValid) {
                System.out.println("Invalid Input. Numbers only. Please try again.");
                isValid = true;
            } else if (this.Dcode.length() > 4 || this.Dcode.length() < 4) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        //get the department office number
        while (isValid) {

            System.out.print("\nPlease enter the Department's office number (XXXX): ");
            this.Office_No = scan.nextLine();
            isValid = (isNumeric(this.Office_No));

            if (!isValid) {
                System.out.println("Invalid Input. Numbers only. Please try again.");
                isValid = true;
            } else if (this.Office_No.length() > 4 || this.Office_No.length() < 4) {
                System.out.println("Invalid Input. Too Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        //get the department office's phone number
        while (isValid) {

            System.out.print("\nPlease enter the Department's office phone number: ");
            this.Office_Phone = scan.nextLine();
            isValid = (isNumeric(this.Office_Phone));

            if (!isValid) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else if (this.Office_Phone.length() > 10 || this.Office_Phone.length() < 10) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;


        //get the department's college
        while (isValid) {

            System.out.print("\nPlease enter the Department's college: ");
            this.College = scan.nextLine();
            isValid = (isNumeric(this.College));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.College.length() > 25) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

    } //end getDatabaseInfo()

    public String inputDatabase() {

        //creates insert statement for student
        String q = "INSERT INTO DEPARTMENT VALUES('" + Dcode + "', '" + DName + "', '" +
        Office_No + "', '" + Office_Phone + "', '" + College + "')";

        return q;
    } //end inputStudent()

    public boolean isNumeric (String s) {
        try {
            Double.parseDouble(s);
            return true;

        } catch (NumberFormatException ex) {
            return false;

        } //end try-catch

    } //end isNumeric()
}
