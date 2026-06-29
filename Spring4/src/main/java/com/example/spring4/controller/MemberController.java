package com.example.spring4.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring4.entity.Info;
import com.example.spring4.entity.Member;
import com.example.spring4.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberService service;
	
	/*
	 * POST / member
	 * {
	 * 		"account":xxx,
	 * 		"passwd": xxx,
	 * 		"info": {
	 * 				"tel": xxx
	 * 				"birthday":xxx
	 * 				"gender": true
	 * 				}
	 * }
	 */
	@PostMapping("")
	public ResponseEntity<Member> addMember(@RequestBody Map<String,Object> data) {
		Member member = new Member();
		member.setAccount((String)data.get("account"));
		member.setPasswd((String)data.get("passwd"));
		
		Info info = null;
		Map<String,Object> infoData = (Map<String,Object>)data.get("info");
		if (infoData != null) {
			info = new Info();
			info.setBirthday((String)infoData.get("birthday"));
			info.setTel((String)infoData.get("tel"));
			info.setIsMale((Boolean)infoData.get("gender"));
		}
		
		Member saveMember = service.save(member, info);
		return ResponseEntity.ok(saveMember);
	}
	
	@PutMapping("/{memberId}/info")
	public ResponseEntity<Info> setMemberInfo(@PathVariable Long memberId,
			@RequestBody Map<String,Object> body){

		Info info = new Info();
		info.setBirthday((String)body.get("birthday"));
		info.setTel((String)body.get("tel"));
		info.setIsMale((Boolean)body.get("gender"));
		
		Info saveInfo = service.setInfo2Member(info, memberId);
		
		return ResponseEntity.ok(saveInfo);
	}
	
	@GetMapping("/{memberId}")
	public ResponseEntity<Member> queryMember(@PathVariable Long memberId){
		return ResponseEntity.ok(service.findMemberById(memberId));
	}
	
	
	
	
}