package com.example.chatapijee.service;

import com.example.chatapijee.model.Message;

import java.util.List;

public interface InterfaceMessageService {
    void save(Message message);

    void getById(Long id);

    List<Message> getMessages();
}
