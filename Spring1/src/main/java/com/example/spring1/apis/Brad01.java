package com.example.spring1.apis;

import org.springframework.stereotype.Component;

/*
 * Ioc => 控制反轉 => Bean 
 * => @Component(類別 -> 物件) 
 * => @Bean(方法 => return物件) 
 */
@Component
public class Brad01 {
	public Brad01() {
		System.out.println("Brad01()");
	}
	public Brad01(int a) {
		System.out.println("Brad01(int)");
	}
}
