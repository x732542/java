package tw.brad.websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions;
	private static Session teacherSession;
	private static boolean isExistTeacher = false;
	
	public MyCenter() {
		if (sessions == null) {
			sessions = new HashSet<>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if (sessions.add(session)) {
			System.out.println("New Session");
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		if (!isExistTeacher && mesg.contains("isTeacher")) {
			isExistTeacher = true;
			teacherSession = session;
			System.out.println("Teacher enter...");
		}else if (teacherSession == session){
			for (Session studentSession : sessions) {
				try {
					studentSession.getBasicRemote().sendText(mesg);
				} catch (IOException e) {
				}
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		//System.out.println("onClose");
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError");
		//sessions.remove(session);
	}
	
	
	
}