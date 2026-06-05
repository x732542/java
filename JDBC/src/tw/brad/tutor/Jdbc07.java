package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc07 {
	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306/brad";

		final String SQL = """
				SELECT * FROM test
				  	""";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		try (Connection conn = DriverManager.getConnection(URL, prop);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);) {
			while (rs.next()) {
				System.out.printf("%s:%s:%s\n", rs.getString("id"),
						rs.getString("cname"),rs.getString("tel"));
			}

//			rs.next();
//			 f1 = rs.getString(1);
//			 f2 = rs.getString(2);
//			System.out.printf("%s:%s\n",f1,f2);
//
//			rs.next();
//			f1 = rs.getString(1);
//			f2 = rs.getString(2);
//			System.out.printf("%s:%s",f1,f2);

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
