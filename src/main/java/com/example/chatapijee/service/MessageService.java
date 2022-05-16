package com.example.chatapijee.service;

import com.example.chatapijee.model.Message;
import com.example.chatapijee.repository.InterfaceMessageRepository;

import java.util.List;

class MessageService implements InterfaceMessageService {

    private InterfaceMessageRepository interfaceMessageRepository;
    @Override
    public void save(Message message) {
        interfaceMessageRepository.save(message);
    }

    public void getById(Long id) {
        interfaceMessageRepository.getById(id);
    }

    @Override
    public List<Message> getMessages() {
       return interfaceMessageRepository.getMessages();
    }


}
