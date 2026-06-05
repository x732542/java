
package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc02 {
	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306/brad?useSSL=false&user=root&password=root";
		final String SQL = """
				INSERT INTO test
				(cname, tel, birthday)
				VALUES ("peter", "123", "1991-01-02")
				  """;
		try (Connection conn = DriverManager.getConnection(URL); 
				Statement stmt = conn.createStatement();) {

			stmt.execute(SQL);
			System.out.println("ok");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
