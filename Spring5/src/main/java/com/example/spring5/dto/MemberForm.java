package com.example.spring5.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class MemberForm {
	@Email
	private String account;
	private String passwd;
	private String name;
	private MultipartFile iconFile;
}