package com.joeri.coffeebay.socketController;

import com.joeri.coffeebay.model.UserOrder;
import com.joeri.coffeebay.socketModel.ChatMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    
    @MessageMapping("/order/coffee")
    @SendTo("/topic/public")
    public UserOrder testsocket (@Payload UserOrder userOrder){
        System.out.println(userOrder);
        return userOrder;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage){
        System.out.println("here " + chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;                            
    }
    
}
