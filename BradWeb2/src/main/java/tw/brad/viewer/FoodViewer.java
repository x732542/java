package tw.brad.viewer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Food;

@WebServlet("/FoodViewer")
public class FoodViewer extends HttpServlet {
	private static final String TEMPLATE_PATH = "/WEB-INF/views/view2.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food> foods = (List<Food>)request.getAttribute("foods");
		Integer prev = (Integer)request.getAttribute("prev");
		Integer page = (Integer)request.getAttribute("page");
		Integer next = (Integer)request.getAttribute("next");
		String title = (String)request.getAttribute("title");
		
		
		//--------------
		String template;
		try {
			String temp = readTemplate(TEMPLATE_PATH);
			String table = readTableHtml(foods);
			
			template = temp.replace("{{PREV}}", prev.toString())
						.replace("{{PAGE}}", page.toString())
						.replace("{{NEXT}}", next.toString())
						.replace("{{TABLE}}", table)
						.replace("{{TITLE}}", title);
			
		} catch (Exception e) {
			template = "ERROR";
			System.out.println(e);
		}
		
		response.getWriter().print(template);
		response.flushBuffer();
		
	}
	
	private String readTemplate(String path) throws Exception{
		//System.out.println(getServletContext().getContextPath());
		try(InputStream in = getServletContext().getResourceAsStream(path);
			BufferedInputStream bin = new BufferedInputStream(in)){
			return new String(bin.readAllBytes(), StandardCharsets.UTF_8);
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception("Template NOT FOUND");
		}
	}
	
	private String readTableHtml(List<Food> foods) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table width='100%' border='1'>")
			.append("<caption>在地美食列表</caption>")
			.append("<thead><tr>")
				.append("<th>編號</th>")
				.append("<th>名稱</th>")
				.append("<th>電話</th>")
				.append("<th>地址</th>")
				.append("<th>圖片</th>")
			.append("</tr></thead>")
			.append("<tbody>");

		for (Food food: foods) {
			sb.append("<tr>");
			sb.append(String.format("<td>%d</td>", food.getId()));
			sb.append(String.format("<td>%s</td>", food.getName()));
			sb.append(String.format("<td>%s</td>", food.getTel()));
			sb.append(String.format("<td>%s%s%s</td>", food.getCity(),food.getTown(),food.getAddr()));
			sb.append(String.format("<td><img src='%s' width='160px' height='90px' /></td>", food.getPicurl()));
			sb.append("</tr>");
		}
		
		sb.append("</tbody>")
			.append("</table>");
		
		return sb.toString();
	}

}