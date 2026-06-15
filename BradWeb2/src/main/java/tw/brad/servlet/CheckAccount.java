package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.dao.MemberDao;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

@WebServlet("/CheckAccount")
public class CheckAccount extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		BufferedReader reader= request.getReader();
		String data = reader.readLine();
		JSONObject root =new JSONObject();
		String account = root.getString("account");
		
		
		//-------------------------------------------
		MemberDao dao = new MemberDao();
		JSONObject obj = new JSONObject();
		obj.put("result", dao.isAccountExist(account));

//		{"result" : true/false }

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(obj);
		response.resetBuffer();
	}
}
