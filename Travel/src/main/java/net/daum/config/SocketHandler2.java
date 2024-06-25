package net.daum.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class SocketHandler2 extends TextWebSocketHandler {

    private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<>());
    private static int seoulTravelerCount = 0; 
       
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        clients.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	seoulTravelerCount = 0; 
        clients.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 메시지 처리 로직 필요시 추가
    }

    
    public void broadcast(String message) {
        synchronized (clients) {
            seoulTravelerCount++;
            String messageWithCount = message + seoulTravelerCount;

            for (WebSocketSession client : clients) {
                try {
                    client.sendMessage(new TextMessage(messageWithCount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
