package tw.brad.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Food;
import tw.brad.dao.FoodDao;

@WebServlet("/FoodMain")
public class FoodMain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		// 2. Model
		List<Food> foods = new FoodDao(page, 7).query();
		// System.out.println(foods.size());
		
		request.setAttribute("title", "Brad Big Company");
		request.setAttribute("foods", foods);
		request.setAttribute("page", page);
		request.setAttribute("prev", page - 1);
		request.setAttribute("next", page + 1);
		
		
		// 3. Viewer
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("FoodViewer").forward(request, response);
	}

}