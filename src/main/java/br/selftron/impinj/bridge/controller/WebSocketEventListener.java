package br.selftron.impinj.bridge.controller;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
    	SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
		System.out.println(headers.getSessionId() + " - " + event.getMessage());
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
    	System.out.println(event.getSessionId() + " - " + event.getMessage());
    }
    
}