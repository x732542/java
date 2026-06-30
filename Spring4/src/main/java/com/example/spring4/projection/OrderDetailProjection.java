package com.example.spring4.projection;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface OrderDetailProjection {
	BigDecimal getUnitPrice();
	int getQuantity();
	
	// SpEL
	@Value("#{target.product.productName}")
	String getProductName();
	
	@Value("#{target.unitPrice * target.quantity}")
	BigDecimal getSubtotal();
	
}