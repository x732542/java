package com.example.spring2.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberForm {
	private String account;
	private List<MultipartFile> files;
}