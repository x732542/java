package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc12 {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/brad";
		final String SQL_QUERY = """
				SELECT name cname,tel,addr,feature
				FROM food
				WHERE name LIKE ? OR tel LIKE ? OR addr LIKE ? OR feature LIKE ?
				""";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Keyword: ");
		String key = scanner.next();
		
		
		try (Connection conn =  DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
				){
			String skey = "%" + key + "%";
			pstmt.setString(1, skey);
			pstmt.setString(2, skey);
			pstmt.setString(3, skey);
			pstmt.setString(4, skey);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("cname");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String feature = rs.getString("feature");
				System.out.printf("%s:%s:%s:%s\n", name, tel, addr, feature);
				System.out.println("-------");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}