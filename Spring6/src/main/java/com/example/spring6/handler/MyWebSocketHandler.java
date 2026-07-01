package com.example.spring6.handler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
	private static final Set<WebSocketSession> sessions = new HashSet<>();
	private static boolean isExistTeacher = false;
	private static WebSocketSession teacherSession;

	public MyWebSocketHandler() {System.out.println("MyWebSocketHandler()");}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished");
		sessions.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String mesg = message.getPayload();
		if (!isExistTeacher && mesg.contains("isTeacher")) {
			isExistTeacher = true;
			teacherSession = session;
			System.out.println("handleTextMessage:" + mesg);
		}else if(session == teacherSession){
			for (WebSocketSession s : sessions) {
				if (s.isOpen()) {
					s.sendMessage(message);
				}
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed");
		if (session == teacherSession) {
			isExistTeacher = false;
			sessions.remove(session);
		}
	}

}