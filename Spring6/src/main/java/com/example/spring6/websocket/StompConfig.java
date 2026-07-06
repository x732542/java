package com.example.spring6.websocket;

import java.security.Principal;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.example.spring6.util.JwtToken;

import jakarta.servlet.http.HttpServletRequest;

/*
 * 1. Client -> /ws-chat?token=xxx
 * 2. 攔截, JwtToken -> account -> attributes
 * 3. 打包 Principal -> WebSocket
 * 4. Message Broker: /app -> /topic
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws-chat")
			.addInterceptors(new HandshakeInterceptor() {
				@Override
				public boolean beforeHandshake(ServerHttpRequest request, 
						ServerHttpResponse response,
						WebSocketHandler wsHandler, 
						Map<String, Object> attributes) throws Exception {
					
					if (request instanceof ServletServerHttpRequest req) {
						HttpServletRequest httreq = req.getServletRequest();
						String tokenParam = httreq.getParameter("token");
						if (tokenParam != null && tokenParam.startsWith("Bearer ")) {
							String token = tokenParam.substring(7);
							String account = JwtToken.parseToken(token);
							attributes.put("account", account);
							return true;
						}
					}
					
					return false;
				}

				@Override
				public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
						WebSocketHandler wsHandler, @Nullable Exception exception) {
				}
			})
			.setHandshakeHandler(new DefaultHandshakeHandler() {

				@Override
				protected @Nullable Principal determineUser(
						ServerHttpRequest request, 
						WebSocketHandler wsHandler,
						Map<String, Object> attributes) {
					
					String account =  (String)attributes.get("account");
					Principal principal = new Principal() {
						@Override
						public String getName() {
							return account;
						}
					};
					
					return principal;
				}
				
			})
			.setAllowedOriginPatterns("*")
			.withSockJS();
	}

	/*
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		WebSocketMessageBrokerConfigurer.super.configureClientInboundChannel(registration);
	}
	 */
	
	
}