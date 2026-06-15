package tw.brad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Member;

public class MemberDao {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_REG = """
			INSERT INTO member
				(account,passwd)
			VALUES
				(?,?)
			""";
	private static final String SQL_CHECKACCOUNT = """
			SELECT count(account) count
			FROM member
			WHERE account = ?
			""";
	public boolean addMember(Member member) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_REG)){
			
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()) );
			
			return  pstmt.executeUpdate() > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	

	public boolean isAccountExist(String account) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_REG)){
			
			pstmt.setString(1, account);
			try (ResultSet rs = pstmt.executeQuery()){
				rs.next();
				return rs.getInt("count")>0;
			} catch (Exception e) {
			}
			return  pstmt.executeUpdate() > 0;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}