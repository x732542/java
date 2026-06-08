package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc21 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_UPDATE = """
			UPDATE member
			SET icon = ?
			WHERE id = ?
			""";

	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			FileInputStream fin = new FileInputStream("dir1/ball0.png")
				){
			
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 1);
			
			int n = pstmt.executeUpdate();
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}