package com.example.spring4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

	@Id
	@Column(name = "ProductID")
	private int productId;
	
	@Column(name = "ProductName")
	private String productName;
	
}