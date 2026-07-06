package com.example.spring6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	private Integer id;
	private String account, passwd, name;
}
