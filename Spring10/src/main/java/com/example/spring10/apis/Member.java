package com.example.spring10.apis;

import com.example.spring10.annotation.CheckLength;

public class Member {
	@CheckLength(min = 6, max = 10, message = "錯誤")
	private String account;
	
	public Member(String account) {
		this.account = account;
	}
}