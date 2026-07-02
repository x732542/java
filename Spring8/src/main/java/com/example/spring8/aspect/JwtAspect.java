package com.example.spring8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.spring8.exception.JwtAuthException;
import com.example.spring8.util.JwtToken;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class JwtAspect {
	
	private static Logger logger = LoggerFactory.getLogger(JwtAspect.class);

	@Around("@annotation(com.example.spring8.annotation.CheckJwt)")
	public Object checkJwt(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes =
		 (ServletRequestAttributes)(RequestContextHolder.getRequestAttributes());
		HttpServletRequest request = attributes.getRequest();
		
		// request.getSession();
		
		String urIp = request.getRemoteAddr();
		
		logger.info(String.format("%s:%s", urIp, "xxxx"));
		
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			// E
			throw new JwtAuthException("no token");
		}
		
		// Bearer xxxxxxx
		System.out.println(authHeader);
		
		// check token
		if (!authHeader.startsWith("Bearer ")) {
			// E
			throw new JwtAuthException("token format error");
		}
		
		try {
			String token = authHeader.substring(7);
			String data = JwtToken.parseToken(token);
			if (data != null) {
				System.out.println(data);
			}else {
				throw new JwtAuthException("token data error");
			}
			
		}catch(Exception e) {
			// E
			throw new JwtAuthException("token data parse error");
		}
		
		return joinPoint.proceed();
		
	}
	
}