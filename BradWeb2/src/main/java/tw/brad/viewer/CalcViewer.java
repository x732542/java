package tw.brad.viewer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.BradUtils;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalcViewer")
public class CalcViewer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String result = (String)request.getAttribute("result");
		String view = (String)request.getAttribute("view");
		
		PrintWriter out = response.getWriter();
		String webContent;
		
		try {
			webContent = BradUtils.loadView(view);
			String content = webContent.replaceAll("#x", x)
							.replaceAll("#y", y)
							.replaceAll("#r", result);
			out.print(content);
			
		} catch (Exception e) {
			System.out.println(e);
			webContent = "Load Html Page Failure";
			out.print(webContent);
		}
		
		response.flushBuffer();
		
	}

}