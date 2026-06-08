package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Jdbc27 {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/brad";
		final String SQL_QUERY = """
				SELECT id, name cname,tel,addr,feature
				FROM food
				""";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		try (Connection conn =  DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE
					);
				){
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String name = rs.getString("cname");
			String tel = rs.getString("tel");
			String addr = rs.getString("addr");
			String feature = rs.getString("feature");
			System.out.printf("%s:%s:%s:%s\n", id, name, tel, addr);
			
			rs.absolute(4);
			System.out.printf("%s:%s\n", rs.getString("id"), rs.getString("cname"));
			
			rs.last();
			System.out.printf("%s:%s\n", rs.getString("id"), rs.getString("cname"));
			
			rs.first();
			System.out.printf("%s:%s\n", rs.getString("id"), rs.getString("cname"));
			
			rs.absolute(10);
			System.out.printf("%s:%s\n", rs.getString("id"), rs.getString("cname"));
			rs.updateString("tel", "1234567");
			rs.updateString("addr", "公益路100號");
			rs.updateRow();
			
			rs.absolute(12);
			rs.deleteRow();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}