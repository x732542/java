package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		String x, y, result, op;
		x = y = result = op = "";
		String s1, s2, s3, s4; s1 = s2 = s3 = s4 = "";
		
		try {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
			int r1, r2;
			switch(op) {
				case "1":
					r1 = Integer.parseInt(x) + Integer.parseInt(y); 
					result += r1; 
					s1 = "selected";
					break;
				case "2":
					r1 = Integer.parseInt(x) - Integer.parseInt(y); 
					result += r1; 
					s2 = "selected";
					break;
				case "3":
					r1 = Integer.parseInt(x) * Integer.parseInt(y); 
					result += r1; 
					s3 = "selected";
					break;
				case "4":
					r1 =  Integer.parseInt(x) / Integer.parseInt(y);
					r2 =  Integer.parseInt(x) % Integer.parseInt(y);
					s4 = "selected";
					result += r1 + " ...... " + r2;
					break;
			}
			
			
		}catch(Exception e) {
			x = y = result = "";
			System.out.println(e);
		}		
		
		//---------------------------------
		response.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = response.getWriter();
		
		// C:\Users\User\eclipse-workspace\BradWeb2\src\main\webapp\brad05.html
		// C:\Users\User\git\repository\BradWeb2\src\main\webapp\brad05.html
		BufferedInputStream bin = new BufferedInputStream(
			new FileInputStream("C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\brad05.html"));
		byte[] data = bin.readAllBytes();
		String html = new String(data);
		
		out.print(String.format(html, x, s1, s2, s3, s4, y, result));
		
		
	}

}