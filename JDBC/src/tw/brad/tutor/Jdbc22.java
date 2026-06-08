package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc22 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_QUERY = """
			SELECT id, account, icon FROM member
			WHERE id = ?
			""";

	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
				){
			
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("icon");
				byte[] alldata = in.readAllBytes();
				
				FileOutputStream fout = new FileOutputStream(
						String.format("dir2/%s.png", rs.getString("account")));
				fout.write(alldata);
				fout.flush();
				fout.close();
				System.out.println("OK");
				
			}else {
				System.out.println("NOT FOUNT!");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}