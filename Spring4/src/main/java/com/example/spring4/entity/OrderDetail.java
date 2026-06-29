package com.example.spring4.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailPK.class)
@Data
public class OrderDetail {
	@Id
	@Column(name = "OrderID")
	private int orderId;
	
	@Id
	@Column(name = "ProductID")
	private int productId; 
	
	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "OrderID")
	@JsonBackReference
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product product;
	
	
}