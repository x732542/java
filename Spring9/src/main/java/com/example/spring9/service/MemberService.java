package com.example.spring9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring9.entity.Member;
import com.example.spring9.repo.MemberRepo;

@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Member member = memberRepo.findByAccount(username).orElse(null);
		if (member == null) throw new UsernameNotFoundException("Account NOT FOUND");
		
		return User.builder()
					.username(member.getAccount())
					.password(member.getPasswd())
					.roles(member.getRole())
					.build();
	}

}