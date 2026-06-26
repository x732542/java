package com.example.spring2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring2.entity.Hotel;
import com.example.spring2.repository.HotelRepository;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	private HotelRepository repository;

	@GetMapping("")
	public ResponseEntity<Map<String,Object>> queryHotelByPage(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int rpp) {
		
		Pageable pageable = PageRequest.of(page, rpp);
		Page<Hotel> hotelPage = repository.findAll(pageable);
		
		Map<String,Object> result = Map.of(
			"data", hotelPage.getContent(),
			"total", hotelPage.getTotalElements(),
			"totalPage", hotelPage.getTotalPages(),
			"page", hotelPage.getNumber(),
			"isLast", hotelPage.isLast()
				);
		
		return ResponseEntity.ok(result);
	}
	
	
}