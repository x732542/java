package com.example.spring5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hotel {
	@Id private Long id;
	private String name, addr, tel;
}