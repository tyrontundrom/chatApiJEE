package com.example.chatapijee.service;

import com.example.chatapijee.dto.JmsMessageDto;
import com.example.chatapijee.dto.MessageType;
import com.example.chatapijee.dto.PrivateMessageDto;
import com.example.chatapijee.dto.PublicMessageDto;
import com.example.chatapijee.mapper.ChatMessageMapper;
import com.example.chatapijee.model.ChatUser;
import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.MessageRepoList;
import com.example.chatapijee.repository.UserRepoList;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotAuthorizedException;
import java.util.Collections;
import java.util.Set;

public class ChatService {

    @Inject
    MessageRepoList messageRepoList;

//    @Inject
//    ChannelRepository channelRepository;


    private static UserRepoList userRepoList = new UserRepoList();

    @Inject
    private JmsMessageService jmsMessageService;

    @Transactional
    public void send(PublicMessageDto publicMessageDto) {
        getUser(publicMessageDto.getSender());
        messageRepoList.addMessage(ChatMessageMapper.INSTANCE.mapPublicToEntity(publicMessageDto));
        JmsMessageDto messageDto = JmsMessageDto.builder()
                .messageType(MessageType.PUBLIC)
                .text(publicMessageDto.getSender() + ": " + publicMessageDto.getMessage())
                .receivers(Collections.emptySet())
                .build();
        jmsMessageService.sendJmsMessage(messageDto);
    }

    private User getUser(String username) {
        User user = userRepoList.getUser(username);
        if (user == null) {
            throw new NotAuthorizedException(user + "not found");
        }
        return user;
    }

    @Transactional
    public void sendToUser(PrivateMessageDto privateMessageDto) {
        getUser(privateMessageDto.getSender());
        getUser(privateMessageDto.getReceiver());
        messageRepoList.addMessage(ChatMessageMapper.INSTANCE.mapPrivateToEntity(privateMessageDto));
        JmsMessageDto messageDto = JmsMessageDto.builder()
                .messageType(MessageType.PRIVATE)
                .text("Private message from " + privateMessageDto.getSender() + ": " + privateMessageDto.getMessage())
                .build();
        jmsMessageService.sendJmsMessage(messageDto);
    }
}
