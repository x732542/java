package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc05 {
	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306/brad";

		final String SQL = """
				DELETE FROM test
				WHERE id >= 6
		    	""";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		try (Connection conn = DriverManager.getConnection(URL, prop);
				Statement stmt = conn.createStatement();) {
//			boolean ret = stmt.execute(SQL);
//			System.out.println(ret);
			
			 int n = stmt.executeUpdate(SQL);
			 System.out.println(n);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
