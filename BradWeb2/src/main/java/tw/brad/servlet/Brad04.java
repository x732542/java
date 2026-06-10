package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String x = request.getParameter("x");
		String y = request.getParameter("y");
		System.out.printf("%s:%s\n", x, y);

		// ------------------------------------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			int r = Integer.parseInt(x) + Integer.parseInt(y);
			out.printf("%s + %s = %d", x, y, r);
		} catch (Exception e) {
			out.printf("ERROR");
		}
	}
}
