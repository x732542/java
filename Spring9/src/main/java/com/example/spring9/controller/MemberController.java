package com.example.spring9.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring9.apis.Member;

@Controller
@RequestMapping("/")
public class MemberController {
	
	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		Model model) {
		
		if (error != null) model.addAttribute("error", "Login Failure");
		if (logout != null) model.addAttribute("logout", "Logout Success");
		
		return "login";
	}

	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("title", "Brad Big Company");
		return "main";
	}
	
	@GetMapping("/member/page1")
	public String page1(Model model) {
		return "/member/page1";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}

	@GetMapping("/admin/page1")
	public String adminPage1(Model model) {
		return "/admin/admin1";
	}
	@GetMapping("/page403")
	public String page403(Model model) {
		return "page403";
	}
	
	@RequestMapping("/member/test01")
	public String test01(Model model) {
		model.addAttribute("name", "<h2>Brad</h2>");
		
		Member member = new Member();
		member.setName("Kevin");
		member.setAge(20);
		
		model.addAttribute("member", member);
		
		member.setId(123);
		member.setAdmin(true);
		
		
		return "/member/test01";
	}	

	@GetMapping("list")
	public String list(Model model) {
		
		Member m1 = new Member();
		m1.setName("Kevin1");
		m1.setAge(20);
		Member m2 = new Member();
		m2.setName("Kevin2");
		m2.setAge(20);
		Member m3 = new Member();
		m3.setName("Kevin3");
		m3.setAge(20);
		
		model.addAttribute("members",List.of(m1,m2,m3));
		
		return "/member/list";
	}
}