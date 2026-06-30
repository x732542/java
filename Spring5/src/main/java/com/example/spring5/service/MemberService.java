package com.example.spring5.service;

import com.example.spring5.controller.WebController;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring5.dto.MemberForm;
import com.example.spring5.entity.Member;
import com.example.spring5.repo.MemberRepo;

@Service
public class MemberService {
	@Autowired
	private MemberRepo memberRepo;

	public Member register(MemberForm memberForm) throws Exception{
		String account = memberForm.getAccount();
		if (memberRepo.findByAccount(account) != null) throw new Exception();
		
		Member member = new Member();
		member.setAccount(memberForm.getAccount());
		member.setPasswd(BCrypt.hashpw(memberForm.getPasswd(), BCrypt.gensalt()));
		member.setName(memberForm.getName());

		MultipartFile iconFile = memberForm.getIconFile();
		byte[] icon = iconFile != null && !iconFile.isEmpty() ? iconFile.getBytes(): null;
		member.setIcon(icon);
		
		return memberRepo.save(member);
	}
	
}