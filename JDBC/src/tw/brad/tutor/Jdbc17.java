package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class Jdbc17 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWDS = "root";
	private static final String SQL_REG = """
			INSERT INTO member
				(account, passwd)
			VALUES
				(?,?)
			""";
	private static final String SQL_CHECK1 = """
			SELECT account
			FROM member
			WHERE account = ?
			""";
	private static final String SQL_CHECK2 = """
			SELECT COUNT(account) count
			FROM member
			WHERE account = ?
			""";
	private static Properties prop = new Properties();

	public static void main(String[] args) {
		System.out.println("Member Register");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String passwd = scanner.nextLine();
		
		prop.put("user", USER);
		prop.put("password", PASSWDS);
		prop.put("useSSL", false);
		
		try {
			if (!isAccountExist(account)) {
				if (regMember(account, passwd)) {
					System.out.println("Register Success");
				}else {
					System.out.println("Register Failure");
				}
			}else {
				System.out.println("Account EXIST!");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static boolean isAccountExist(String account) throws Exception{
		/*
		try(Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK1)){
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		}
		*/
		
		try(Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK2)){
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count") > 0;
		}
		
	}
	
	private static boolean regMember(String account, String passwd) throws Exception {
		try(Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_REG)){
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			int n = pstmt.executeUpdate();
			return n > 0;
		}
	}

}