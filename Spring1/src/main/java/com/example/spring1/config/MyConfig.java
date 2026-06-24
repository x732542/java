package com.example.spring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.spring1.utils.User;

import tools.jackson.databind.ObjectMapper;

@Configuration
public class MyConfig {
	public MyConfig() {System.out.println("MyConfig()");}
	
	@Bean
	public User m1() {
		System.out.println("MyConfig:m1()");
		User user = new User();
		user.setAge(18);
		user.setName("brad");
		return user;
	}
	
	@Bean
	public RestTemplate m2() {
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper m3() {
		return new ObjectMapper();
	}


}