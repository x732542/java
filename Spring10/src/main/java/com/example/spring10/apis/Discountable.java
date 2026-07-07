package com.example.spring10.apis;

public interface Discountable {
	int getVipLevel();
	
	default double calcDiscount(double price) {
		int level = getVipLevel();
		switch(level) {
		case 1 :return price * 0.9;
		case 2 :return price * 0.7;
		case 3 :return price * 0.5;
		}
		return price ;
	}
	
}
