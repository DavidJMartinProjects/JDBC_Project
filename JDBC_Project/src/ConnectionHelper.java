import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionHelper {

	public static Connection con;
	public static Statement st;
	public static ResultSet rs;

	public ConnectionHelper() {
		con = null;
		st = null;
		rs = null;
	}

	public static void DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aer_lingus", "root", "");
			st = con.createStatement();
			System.out.println("JDBC Connection Established...");
		} catch (Exception ex) {
			System.out.println("Exception : Unable to load JDBC Driver - " + ex);
		}
	}

}
