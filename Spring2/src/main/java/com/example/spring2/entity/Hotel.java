package com.example.spring2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hotel {
	@Id
	private Long id;
	private String name, adde, tel;

}
