package com.example.spring4.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring4.entity.Info;
import com.example.spring4.entity.Member;
import com.example.spring4.repo.InfoRepo;
import com.example.spring4.repo.MemberRepo;

@Service
public class MemberService {
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private InfoRepo infoRepo;
	
	@Transactional
	public Member save(Member member, Info info) {
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		member.setInfo(info);
		return memberRepo.save(member);
	}

	@Transactional
	public Info setInfo2Member(Info info, Long memberId) {
		Member member = memberRepo.findById(memberId).orElse(null);
		if (member != null) {
			Info i = member.getInfo();
			if (i != null) {
				info.setId(memberId);
			}
			member.setInfo(info);
			Member save = memberRepo.save(member);
			return save.getInfo();
		}
		return null;
	}
	
	public Member findMemberById(Long memberId) {
		return memberRepo.findById(memberId).orElse(null);
	}
	
}