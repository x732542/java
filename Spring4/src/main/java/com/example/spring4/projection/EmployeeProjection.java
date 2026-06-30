package com.example.spring4.projection;

import java.util.List;

/*
 * 方法名稱 -> Entity
 */
public interface EmployeeProjection {
	String getLastName();
	String getFirstName();
	String getTitle();
	List<OrderProjection> getOrders();
}