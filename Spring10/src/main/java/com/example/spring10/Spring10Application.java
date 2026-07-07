package com.example.spring10;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring10.apis.Member;
import com.example.spring10.enums.OrderStatus;
import com.example.spring10.validator.Validator;

@SpringBootApplication
public class Spring10Application {

	public Spring10Application() {
		Member member = new Member("bradchao");
		try {
			Validator.validate(member);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Spring10Application.class, args);
	}

}