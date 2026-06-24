package com.example.spring1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Hotel {
	private Long id;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Address")
	private String addr;
	
	@JsonProperty("Tel")
	private String tel;
	
	private int error;
}