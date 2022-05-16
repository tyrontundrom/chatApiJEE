package com.example.chatapijee.repository;

import com.example.chatapijee.model.Message;

import java.util.List;

public interface InterfaceMessageRepository {

    void save(Message message);

    List<Message> getMessages();

    void getById(Long id);
}
