package tw.brad.filter;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
	private static final Set<String> WHITE_LIST = Set.of(
			"/login", "/checkAccount", "/public", "/css", "/js", "/img"
			);
	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		System.out.println("before doFilter");
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.sendRedirect("error");
		
		System.out.println("after doFilter");
	}
	
	
	
}