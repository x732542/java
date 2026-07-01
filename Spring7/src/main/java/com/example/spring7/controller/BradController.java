package com.example.spring7.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring7.annotation.BradAOP;

@RestController
@RequestMapping("/brad")
public class BradController {

	@RequestMapping("/test1")
	public void test1() {
		System.out.println("BradController:test1()");
	}
	
	@BradAOP
	@RequestMapping("/test2")
	public void test2() {
		System.out.println("BradController:test2()");
	}

	@BradAOP
	@RequestMapping("/test3")
	public void test3(
			@RequestParam String name, 
			@RequestParam int age) {
		System.out.println("BradController:test3()");
		System.out.printf("BradController:test3(): %s :%d\n",name, age);
	}
	
}