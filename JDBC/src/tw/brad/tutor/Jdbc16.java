package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class Jdbc16 {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/brad";
		final String SQL_INSERT = """
				INSERT INTO member
				(account, passwd)
				VALUES
				(?,?)
				""";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		prop.put("useSSL", false);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		
		
		try (Connection conn =  DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT)
				){
			String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
			pstmt.setString(1, account);
			pstmt.setString(2, hashPasswd);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("Create Success");
			}else {
				System.out.println("Insert Failure");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}