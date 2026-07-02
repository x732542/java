package com.example.spring8.exception;

public class JwtAuthException extends RuntimeException {

	public JwtAuthException(String message) {
		super(message);
	}

}