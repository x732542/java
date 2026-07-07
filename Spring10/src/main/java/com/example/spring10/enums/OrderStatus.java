package com.example.spring10.enums;

//public enum OrderStatus {
//	PENDING, PAID, SHIPPED, FINISH
//}

public enum OrderStatus {
	PENDING(0,"代處理"),
	PAID(1,"已付款"),
	SHIPPED(2,"已出貨"),
	FINISH(3,"已送達");
	
	private final int code;
	private final String desc;
	OrderStatus(int code, String desc){ //private
		this.code = code;
		this.desc =desc;
	}
	public int getCode() {return code;}
	public String getDesc() {return desc;}
	
}