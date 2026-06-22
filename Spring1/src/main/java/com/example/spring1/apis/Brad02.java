package com.example.spring1.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // => Bean => Ioc => Server Starting
@RequestMapping("member")
public class Brad02 {
	public Brad02() {
		System.out.println("Brad02()");
	}

	@RequestMapping("/del/4")
	public void test1() {
		System.out.println("Brad02:test1()");
	}

	@RequestMapping("/test2")
	public void test2() {
		System.out.println("Brad02:test2()");
	}

	@RequestMapping("/test3")
	public String test3() {
		System.out.println("Brad02:test3()");
		return "<h1> 香蕉</h1>";
	}
}
