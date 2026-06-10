package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad17")
public class Brad17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true); // 沒有 -> new
//		 HttpSession session =  request.getSession(false);	// 沒有 -> null

		session.setMaxInactiveInterval(10);
		
		int lottery = (int) (Math.random() * 49 + 1);

		session.setAttribute("lottery", lottery);

		//page, request, session, application
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(lottery);
	}
}
