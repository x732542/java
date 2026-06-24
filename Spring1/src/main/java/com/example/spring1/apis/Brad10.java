package com.example.spring1.apis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.dto.Hotel;
import com.example.spring1.dto.HotelRowMapper;

@RestController
@RequestMapping("/hotels")
public class Brad10 {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private HotelRowMapper hotelRowMapper;
	
	@GetMapping("")
	public List<Hotel> findAll(){
		String sql = "SELECT id, name, addr, tel FROM hotel";
		return jdbc.query(sql, hotelRowMapper);
	}
	
	@GetMapping("/{id}")
	public Hotel findById(@PathVariable Long id) {
		String sql = "SELECT id, name, addr, tel FROM hotel WHERE id = :id";
		HashMap<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		
		List<Hotel> hotels = jdbc.query(sql, params, hotelRowMapper);
		
		if (hotels.size() > 0) {
			Hotel hotel = hotels.get(0);
			hotel.setError(0);
			return  hotel;
		}else {
			Hotel hotel = new Hotel();
			hotel.setError(-1);
			return hotel;
		}
		
	}
	
	
	
}