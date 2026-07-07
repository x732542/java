package com.example.spring10.apis;

import lombok.Data;

@Data
public class Customer implements Discountable{
	private int viplevel;
	
	public Customer(int viplevel) {
		this.viplevel = viplevel;
	}
	
	@Override
	public int getVipLevel() {
		 return viplevel;
	}
}
