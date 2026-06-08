package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.brad.apis.Bike;

public class Jdbc24 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_QUERY = """
			SELECT id, account, bike FROM member
			WHERE id = ?
			""";

	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
				){
			
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("bike");
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				if (obj instanceof Bike) {
					Bike bike = (Bike)obj;
					System.out.println(bike);
				}else {
					System.out.println("NO Bike");
				}
				
				
				System.out.println("OK");
				
			}else {
				System.out.println("NOT FOUNT!");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}