package com.example.spring8.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring8.annotation.CheckJwt;
import com.example.spring8.dto.Login;
import com.example.spring8.util.JwtToken;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> login(
			@RequestBody Login login){
		if (login.getAccount().equals("brad") && login.getPasswd().equals("123456")) {
			String data = String.format("%d:%s", 123, login.getAccount());
			String token = JwtToken.createToken(data);
			Map<String,Object> resp = Map.of(
					"success", true,
					"token", token
					);
			return ResponseEntity.ok(resp);
		}else {
			Map<String,Object> resp = Map.of(
					"success", false
					);
			return ResponseEntity.ok(resp);
		}
		
		
	}
	
	@CheckJwt
	@GetMapping("/main")
	public ResponseEntity<Map<String,Object>> main(){
		System.out.println("Data...");
		return ResponseEntity.ok(Map.of("success",true, "data", "Member Only"));
	}
	
}