package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import tw.brad.apis.Bike;

public class Jdbc23 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_UPDATE = """
			UPDATE member
			SET bike = ?
			WHERE id = ?
			""";

	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.println(b1);
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
				){
			
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			
			int n = pstmt.executeUpdate();
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}