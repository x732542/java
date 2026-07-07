package com.example.spring9.apis;

import lombok.Data;

@Data
public class Member {
	private String name;
	private int age;
	
	private int id;
	private boolean isAdmin;
}