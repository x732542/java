package com.example.spring10.apis;

/*
 * public static final
 */

public interface User {
	String name = "nobody";// public static final
	
	default void printName() {
		System.out.println(name);
	}
}
