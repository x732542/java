package tw.brad.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		final String URL = "jdbc:mysql://localhost:3306/brad?useSSL=false";
		final String SQL = """
				SELECT id, cname
				FROM test
				""";
		try (Connection conn =  DriverManager.getConnection(URL, "root", "root");
			Statement stmt = conn.createStatement();){
			
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				System.out.printf("%s:%s\n", id, cname);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
		
		response.setContentType("text/html; charset=UTF-8");
	}

}