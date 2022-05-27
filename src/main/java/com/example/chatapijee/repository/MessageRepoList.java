package com.example.chatapijee.repository;

import com.example.chatapijee.model.Message;
import com.example.chatapijee.model.User;

import java.util.ArrayList;
import java.util.List;

public class MessageRepoList {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> show() {
        return messages;
    }

//    public void show() {
//        messages.forEach(System.out::println);
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Message m : messages) {
            sb.append(m + "\n");
        }
        return "messages={\n" + sb +
                '}';
    }
}
