package com.example.spring8.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.spring8.exception.JwtAuthException;

@RestControllerAdvice	// RestController 攔截處理器
public class GlobalExceptionHandler {

	@ExceptionHandler(JwtAuthException.class)
	public ResponseEntity<Map<String,Object>> handleJwtAuthException(JwtAuthException e){
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.body(Map.of("success",false, "mesg", "權限被拒"));
	}
	
}