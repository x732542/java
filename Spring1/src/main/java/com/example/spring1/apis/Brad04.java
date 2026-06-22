package com.example.spring1.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad04")
public class Brad04 {

	@RequestMapping("/calc")
	public String calc() {
		return "13";
	}
}
