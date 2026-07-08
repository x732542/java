package com.example.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring11.dto.Login;
import com.example.spring11.entity.Member;
import com.example.spring11.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Login login){
		try {
			Member member = memberService.register(
					login.getAccount(), login.getPasswd(), login.getName());
			
			//member.setAccount("bradxxx");
			
			return ResponseEntity.ok(member);
		}catch(Exception e) {
			return ResponseEntity.ok("error: " + e.getMessage());
		}
		
	}
	
}