package com.example.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring5.dto.MemberForm;
import com.example.spring5.entity.Member;
import com.example.spring5.service.MemberService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public String register(Model model) {
		MemberForm form = new MemberForm();
		model.addAttribute("memberForm", form);
		return "register";
	}
	
	@PostMapping("/register")
	public String doRegister(Model model, 
			@ModelAttribute @Valid MemberForm memberForm,
			BindingResult bindingResult 
			) {
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		try {
			Member member = memberService.register(memberForm);
			return "redirect:/member/login";
		}catch(Exception e) {
			System.out.println(e);
			model.addAttribute("error", "帳號已存在 ");
			return "register";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	
}