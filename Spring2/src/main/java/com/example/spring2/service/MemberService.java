package com.example.spring2.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.spring2.entity.Member;
import com.example.spring2.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
	public boolean checkAccount(String account) {
		return repository.existsByAccount(account);
	}
	
	public boolean register(Member member) {
		if (checkAccount(member.getAccount())) return false;
		
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));

		Member m = repository.save(member);
		System.out.println(m.getId() +":" + m.getPasswd());
		return m!= null;
	}
	
	public boolean login(String account, String passwd) {
		Member member = repository.findByAccount(account).orElse(null);
		if (member != null && BCrypt.checkpw(passwd, member.getPasswd()) ) {
			return  true;
		}
		return false;
	}
	public boolean loginV2(String account, String passwd) {
		Member member = new Member();
		member.setAccount(account);
		Example<Member> ex = Example.of(member);
		if (repository.exists(ex)) {
			List<Member> members = repository.findAll(ex);
			Member dbMember = members.get(0);
			if (BCrypt.checkpw(passwd, dbMember.getPasswd())) {
				return true;
			}
		}
		return false;
	}
	public Member loginV3(String account, String passwd) {
		Member member = repository.findByAccount(account).orElse(null);
		if (member != null && BCrypt.checkpw(passwd, member.getPasswd()) ) {
			return  member;
		}
		return null;
	}
	
	
}