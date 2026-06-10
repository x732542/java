package tw.brad.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

@WebServlet("/Brad10")
public class Brad12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("brad13.html");
		
		//----------------------
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> Brad Big Company</h1>");

		out.println("<hr/>");		
		out.println("<hr/>");
		
		response.setContentType("text/html; charset=UTF-8");

	}
}
