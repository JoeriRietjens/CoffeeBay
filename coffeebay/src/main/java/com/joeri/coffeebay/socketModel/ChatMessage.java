package com.joeri.coffeebay.socketModel;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ChatMessage{

    @Getter
    private MessageType type;
    
    @Getter
    private String content;
    
    @Getter
    private String sender;
    
    @Getter
    private String time;
}

