package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Member;
import tw.brad.dao.MemberDao;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
	
		Member member = new Member();
		member.setAccount(account); member.setPasswd(passwd);
		MemberDao dao = new MemberDao();
		if (dao.addMember(member)) {
			response.sendRedirect("brad27.jsp");
		}else {
			response.sendRedirect("brad26.jsp?errType=1");
		}
	
	}

}