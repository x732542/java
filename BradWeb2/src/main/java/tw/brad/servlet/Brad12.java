package tw.brad.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad13");
		
		request.setAttribute("y", 35);
		
		Bike b1 = new Bike();
		request.setAttribute("bike", b1);
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();
		
		
		//----------------
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Brad Big Company</h1>");
		
		out.println("<hr />");
		dispatcher.include(request, response);
		
		
		out.println("<hr />");
		
		out.println("<div>Footer</div>");

	}

}