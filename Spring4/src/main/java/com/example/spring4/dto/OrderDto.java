package com.example.spring4.dto;

import java.util.Date;
import java.util.List;

public record OrderDto(
		Integer orderId,
		Date orderDate,
		List<OrderDetailDto> details
		) {}