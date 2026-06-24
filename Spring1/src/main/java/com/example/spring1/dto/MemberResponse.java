package com.example.spring1.dto;

import org.springframework.stereotype.Component;

import com.example.spring1.utils.Member;

import lombok.Data;

/*
 * {
 * 		"error": 0,
 * 		"message": "",
 * 		"member": member
 * }
 */
@Data
@Component
public class MemberResponse {
	private int error;
	private String message;
	private Member member;
}