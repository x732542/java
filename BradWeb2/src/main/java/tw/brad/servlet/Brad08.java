package tw.brad.servlet;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
		location = "C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\upload"
		)
@WebServlet("/Brad08")
public class Brad08 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		System.out.println(account);
		
		Collection<Part> parts = request.getParts();
		for (Part part: parts) {
			String type = part.getContentType();
			String name = part.getName();
			long size = part.getSize();
			String sname = part.getSubmittedFileName();
			
			//System.out.printf("%s:%s:%d:%s\n", type, name, size, sname);
			
			if (name.equals("upload") && size > 0) {
				part.write(String.format("%s_%s", account, sname));
			}
			
		}
		
		
		response.setContentType("text/html; charset=UTF-8");		
	
	}

}