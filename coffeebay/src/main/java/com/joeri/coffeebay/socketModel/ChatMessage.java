package com.joeri.coffeebay.socketModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joeri.coffeebay.model.UserOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ChatMessage{
    
    @JsonProperty("type")
    @Getter
    private MessageType type;

    @JsonProperty("content")
    @Getter
    @Setter
    private UserOrder content;

    @JsonProperty("sender")
    @Getter
    private String sender;

    //private String time;

    // public String getTime() {
    //     return this.time;
    // }

    // public void setTime(String time) {
    //     this.time = time;
    // }

}

