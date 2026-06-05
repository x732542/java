package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc13 {
	public static void main(String[] args) {
		final int rpp = 10;
		final String URL = "jdbc:mysql://localhost:3306/brad";
		final String SQL_QUERY = """
				SELECT id, name,tel
				FROM food
				LIMIT ?, ?
				""";

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Page: ");
		int page = scanner.nextInt();
		int start = (page - 1) * rpp;

		try (Connection conn = DriverManager.getConnection(URL, prop);
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);) {
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				System.out.printf("%s:%s:%s\n", id, name, tel);
				System.out.println("-------");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}