package com.example.spring8.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring8.util.JwtToken;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/test1")
	public void test1() {
		String member = "1:brad@brad.tw";
		String token = JwtToken.createToken(member);
		System.out.println(token);
	}
	
	@RequestMapping("/test2/{token}")
	public void test2(@PathVariable String token) {
		String subject = JwtToken.parseToken(token);
		System.out.println(subject);
	}

}