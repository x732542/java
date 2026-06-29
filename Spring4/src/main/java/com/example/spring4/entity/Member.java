package com.example.spring4.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String account, passwd;
	//----------------
	@OneToOne(
			mappedBy = "member",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	private Info info;
	
	public void setInfo(Info info) {
		this.info = info;
		if (info != null) {
			info.setMember(this);
		}
	}
	
}