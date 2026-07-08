package com.example.spring11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spring11.repo.MemberRepo;
import com.example.spring11.service.MemberService;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	@Mock
	MemberRepo repo;
	
	@InjectMocks
	MemberService service;
	
	@Test //
	void register_success() {
		
	}
	
}
