package com.example.spring4.dto;

import java.math.BigDecimal;

public record OrderDetailDto(
		BigDecimal price, Integer qty, String productName) {}