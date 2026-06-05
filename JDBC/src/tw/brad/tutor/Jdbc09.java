package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc09 {
	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306/brad";
		final String SQL_INSERT = """
				INSERT INTO test
				(cname, tel, birthday)
				VALUES
				(?,?,?)
				  	""";
		final String SQL_QUERY = """
				select * from test
				""";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String cname = scanner.next();
		System.out.print("Tel: ");
		String tel = scanner.next();
		System.out.print("Birthday: ");
		String birthday = scanner.next();

		try (Connection conn = DriverManager.getConnection(URL, prop);
				PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
				Statement stmt =conn.createStatement();
				) {
			pstmt.setString(1, cname);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				ResultSet rs = stmt.executeQuery(SQL_QUERY);
				while (rs.next()) {
					System.out.printf("%s:%s:%s\n", rs.getString("id"), rs.getString("cname"), rs.getString("tel"));
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
