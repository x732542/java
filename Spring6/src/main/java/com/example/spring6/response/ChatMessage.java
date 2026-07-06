package com.example.spring6.response;

import lombok.Data;

@Data
public class ChatMessage {
	private String account, content, time;
}