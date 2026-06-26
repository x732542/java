package com.example.spring1.dto;

import lombok.Data;

@Data
public class OrderDetail {
	private int id;
	private String pname;
	private double price;
	private int qty;
}