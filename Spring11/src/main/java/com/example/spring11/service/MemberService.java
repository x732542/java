package com.example.spring11.service;

import org.hibernate.annotations.Audited;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring11.entity.Member;
import com.example.spring11.repo.MemberRepo;

@Service
public class MemberService {
	@Autowired
	private MemberRepo memberRepo;
	
	public Member register(String account, String passwd, String name) {
		if (memberRepo.existsByAccount(account)) 
			throw new IllegalArgumentException("Account EXIST");
		
		Member member = new Member();
		member.setAccount(account);
		member.setPasswd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
		member.setName(name);
		
		Member savedMember = memberRepo.save(member);
		return savedMember;
	}
	
	
}