package tw.brad.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter("/*")
public class MyFilter extends HttpFilter implements Filter {
	public MyFilter() {System.out.println("MyFilter");}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before doFilter");
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		System.out.println("after doFilter");
	}
	
	
	
}