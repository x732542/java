package com.example.spring4.projection;

import java.util.Date;
import java.util.List;

public interface OrderProjection {
	Integer getOrderid();
	Date getOrderdate();
	List<OrderDetailProjection> getOrderDetails();
}