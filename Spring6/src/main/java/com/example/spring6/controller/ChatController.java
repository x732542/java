package com.example.spring6.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring6.response.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat/send")
	@SendTo("/topic/public")
	public ChatMessage handleMessage(String content, Principal principal) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setAccount(principal.getName());
		chatMessage.setContent(content);
		chatMessage.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		return chatMessage;
	}
	
}