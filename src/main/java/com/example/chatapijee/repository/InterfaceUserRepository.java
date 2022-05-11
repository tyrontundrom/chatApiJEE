package com.example.chatapijee.repository;


import com.example.chatapijee.model.User;

public interface InterfaceUserRepository {

    void addUser(User user);

    User getUser(Integer id);
}
