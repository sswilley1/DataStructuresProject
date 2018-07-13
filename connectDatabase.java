import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDatabase{ 

	
	public static void main(String[] args) { 
		connectDatabase tony = new connectDatabase();
		tony.createConnection();
	}
	
	void createConnection() { 
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9247157","sql9247157","ZY9rN5phwb");
			System.out.println("Database connection success");
		}
		catch (ClassNotFoundException ex) { 
			Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}