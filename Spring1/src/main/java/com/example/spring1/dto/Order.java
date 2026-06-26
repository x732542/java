package com.example.spring1.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	private int orderId;
	private String orderDate;
	private List<OrderDetail> details = new ArrayList<>();
}