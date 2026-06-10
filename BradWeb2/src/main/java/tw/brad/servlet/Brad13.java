package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad13")
public class Brad13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String x = request.getParameter("x");
		//String y = request.getParameter("y");
		Integer y = (Integer)request.getAttribute("y");
		Bike b1 = (Bike)request.getAttribute("bike");
		
		PrintWriter out = response.getWriter();
		out.println("Brad13");
		out.printf("x = %s<br />", x);
		out.printf("y = %d<br />", y);
		out.printf("bike = %f<br />", b1.getSpeed());
	
	}

}