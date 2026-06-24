package com.example.spring1.apis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.utils.User;
import com.fasterxml.jackson.annotation.JsonRawValue;

@RestController
@RequestMapping("/brad04")
public class Brad04 {

	@RequestMapping("/calc")
	public String calc(
			@RequestParam(required = false, defaultValue = "0") String x, 
			@RequestParam(required = false, defaultValue = "0") String y) {

		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			int intR = intX + intY;
			return intR + "";
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	@RequestMapping("/test1")
	public void test1(@RequestBody User user) {
		System.out.println("debug");
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getGender());
	}

	@RequestMapping("/test2/{name}/{id}")
	public void test2(@PathVariable String name,@PathVariable String id) {
		System.out.println(name);
		System.out.println(id);
	}

	@RequestMapping("/test3")
	public void test3(@RequestHeader(name = "Content-Type") String contentType,
			@RequestHeader String x) {
		System.out.println(contentType);
		System.out.println(x);
	}
	
	@RequestMapping("/test4/{name}/{id}")
	public void test4(
			@RequestParam(required = false, defaultValue = "0") String x, 
			@RequestParam(required = false, defaultValue = "0") String y,
			@RequestBody User user,
			@PathVariable String name,@PathVariable String id,
			@RequestHeader(name = "Content-Type") String contentType,
			@RequestHeader String xx) {
		
		System.out.printf("%s:%s\n",x,y);
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getGender());
		System.out.println(name);
		System.out.println(id);
		System.out.println(contentType);
		System.out.println(xx);
	}
}