package com.example.chatapijee.dto;

import lombok.Builder;

import java.io.Serializable;
import java.util.Set;

@Builder
public class JmsMessageDto implements Serializable {
    private static final long serialVersionUID = 4301336120077008522L;
    private String text;
    private Set<String> receivers;
    MessageType messageType;
}
