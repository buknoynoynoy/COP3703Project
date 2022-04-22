package package1;

import java.util.*;

public class SQLStudentInputs extends Object {

    Scanner scan = new Scanner(System.in);

    private boolean isValid = true;

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
        while (isValid) {

            System.out.println("Please enter the student's SSN: ");
            this.Ssn = scan.nextLine();
            isValid = (isNumeric(this.Ssn));

            if (!isValid) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else if (this.Ssn.length() > 9 || this.Ssn.length() < 9) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        //Enter Student's Nnumber
        while (isValid) {
            System.out.print("\nPlease enter the students N-Number in this format (N--------): ");
            this.Nnumber = scan.nextLine();
            isValid = (isNumeric(this.Nnumber));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.Nnumber.length() > 9 || this.Nnumber.length() < 9) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                if (Character.toString(this.Nnumber.charAt(0)).equals("n")) {
                    this.Nnumber = this.Nnumber.replace("n", "N");
                }
            }
        }
        isValid = true;

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

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.sClass.length() > 10) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        //Enter student's degree
        while (isValid) {

            System.out.print("\nEnter your student's degree (BA, BS, PHD): ");
            this.Degree = scan.nextLine();
            isValid = (isNumeric(this.Degree));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.Degree.length() > 4 || this.Degree.length() < 2) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        //Enter student's current phone address
        while (isValid) {

            System.out.print("\nPlease enter the student's current phone number: ");
            this.Cphone = scan.nextLine();
            isValid = (isNumeric(this.Cphone));

            if (!isValid) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else if (this.Cphone.length() > 10 || this.Cphone.length() < 10) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        //Enter student's current city
        while (isValid) {

            System.out.print("\nEnter the current city: ");
            this.Ccity = scan.nextLine();
            isValid = (isNumeric(this.Ccity));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.Ccity.length() > 20) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        //Enter student's current state
        while (isValid) {

            System.out.print("\nEnter the current state: ");
            this.Cstate = scan.nextLine();
            isValid = (isNumeric(this.Cstate));

            if (isValid) {
                System.out.println("Invalid Input. Please try again.");
            } else if (this.Cstate.length() > 20) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            }
        }
        isValid = true;

        //Enter the student's current zip
        while (isValid) {

            System.out.print("\nEnter the student's current zip: ");
            this.Czip = scan.nextLine();
            isValid = (isNumeric(this.Czip));

            if (!isValid) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else if (this.Czip.length() > 5 || this.Cphone.length() < 5) {
                System.out.println("Invalid Input. Please try again.");
                isValid = true;
            } else {
                break;
            }
        }
        isValid = true;

        System.out.print("\nAre these the same as your permanent address? 1 for yes -1 for no: ");
        sameAddress = scan.nextLine();

        if (sameAddress.equals("1")) {
            this.Pphone = this.Cphone;
            this.Pcity = this.Ccity;
            this.Pstate = this.Cstate;
            this.Pzip = this.Czip;

        } else if (sameAddress.equals("-1")) {
            //Enter student's permanent phone address
            while (isValid) {

                System.out.print("\nPlease enter the student's permanent phone number: ");
                this.Pphone = scan.nextLine();
                isValid = (isNumeric(this.Pphone));

                if (!isValid) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                } else if (this.Pphone.length() > 10 || this.Pphone.length() < 10) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                } else {
                    break;
                }
            }
            isValid = true;

            //Enter student's permanent city
            while (isValid) {

                System.out.print("\nPlease enter the permanent city: ");
                this.Pcity = scan.nextLine();
                isValid = (isNumeric(this.Pcity));

                if (isValid) {
                    System.out.println("Invalid Input. Please try again.");
                } else if (this.Pcity.length() > 20) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                }
            }
            isValid = true;

            //Enter student's current state
            while (isValid) {

                System.out.print("\nEnter the current state: ");
                this.Pstate = scan.nextLine();
                isValid = (isNumeric(this.Pstate));

                if (isValid) {
                    System.out.println("Invalid Input. Please try again.");
                } else if (this.Pstate.length() > 20) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                }
            }
            isValid = true;

            //Enter the student's current zip
            while (isValid) {

                System.out.print("\nEnter the student's current zip: ");
                this.Pzip = scan.nextLine();
                isValid = (isNumeric(this.Pzip));

                if (!isValid) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                } else if (this.Pzip.length() > 5 || this.Pphone.length() < 5) {
                    System.out.println("Invalid Input. Please try again.");
                    isValid = true;
                } else {
                    break;
                }
            }
            isValid = true;
        } //end else if

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
