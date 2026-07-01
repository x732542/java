package com.example.spring5.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring5.entity.Hotel;
import com.example.spring5.entity.Member;
import com.example.spring5.repo.HotelRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private HotelRepo hotelRepo;
	
	@GetMapping("")
	public String home(
			HttpSession session, 
			Model model,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue =  "10") int size
			) {
		Object obj = session.getAttribute("member");
		if (obj == null) return "redirect:/members/login";
		
		Member member = (Member)obj;
		model.addAttribute("member", member);
		if (member.getIcon() != null) {
			String iconString = "data:image/*; base64, " 
					+ Base64.getEncoder().encodeToString(member.getIcon());
			model.addAttribute("icon", iconString);
		}else {
			model.addAttribute("icon", "");
		}
		//---------------------------------
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Hotel> pageHotel = hotelRepo.findAll(pageable);
		
		model.addAttribute("hotels", pageHotel);
		model.addAttribute("page", page);
		
		return "home";
	}
	
	
	
	
}