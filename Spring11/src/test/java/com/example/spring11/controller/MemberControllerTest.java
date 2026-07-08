package com.example.spring11.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.spring11.dto.Login;
import com.example.spring11.entity.Member;
import com.example.spring11.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {
	@Autowired
	private MockMvc mockMvc;	// HTTP: POST: /api/member/register : Content-type: json
	
	@MockitoBean
	private MemberService memberService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	@DisplayName("測試 register -> 200, Member")
	void register_success() throws Exception{
		Login login = new Login("brad", "123456", "Brad");
		
		Member mockMember = new Member();
		mockMember.setAccount("brad");
		mockMember.setPasswd("sdkfgjwdtlghdfgdthf");
		//-------------------------------------------
		when(memberService.register(anyString(), anyString(), anyString()))
			.thenReturn(mockMember);
		//-----------------------------------------
		mockMvc.perform(post("/api/member/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(login)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.account").value("brad"))
			.andExpect(jsonPath("$.passwd").value("sdkfgjwdtlghdfgdthf"));
		
	}
	
	@Test
	@DisplayName("測試 register -> 200, error")
	void register_failure() throws Exception {
		Login login = new Login("brad", "123456", "Brad");
		//------------------------------
		when(memberService.register(anyString(), anyString(), anyString()))
		.thenThrow(new RuntimeException("xxxx"));
		//-----------------
		
		mockMvc.perform(
				post("/api/member/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(login)))
			.andExpect(status().isOk())
			.andExpect(content().string("error: xxxx"));
	}

	
	
}