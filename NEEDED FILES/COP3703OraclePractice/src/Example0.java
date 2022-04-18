import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example0 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "yourUserName";
        String password = "yourPassword";
        try {
			Connection conn = DriverManager.getConnection(url, username, password);
			
	        boolean reachable = conn.isValid(10);// 10 sec

	        if(reachable) {
	        	
	        	System.out.println("Sucess");
	        	conn.close();
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
}
