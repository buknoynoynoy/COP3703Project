package package1;
import java.sql.*;
import java.io.*;

public class SQLInputs extends StudentDatabase {
    
    public String inputStudent(String Fname, char Minit, String Lname, String Ssn, 
    String Nnumber, String Bdate, char Sex, String sClass, String Degree, String Cphone, 
    String Ccity, String Cstate, String Czip, int Pphone, String Pcity, String Pstate, String Pzip) {
        
        //Statement stmt = conn.createStatement();
         String q = "INPUT INTO STUDENT VALUES( '" + Fname + "', '" + Minit +
         "', '" + Lname + "', '" + Ssn + "', '" + Nnumber + "', TO_DATE('" +
         Bdate + "', 'YYYY-MM-DD'), '" + Sex + "', '" + sClass + "', '" + Degree + "', '" +
         Cphone + "', '" + Ccity + "', '" + Cstate + "', '" + Czip + "', '" +
         Pphone + "', '" + Pcity + "', '" + Pstate + "', '" + Pzip + ")";

         return q;
    }
}
