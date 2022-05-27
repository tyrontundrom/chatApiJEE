package com.example.chatapijee.service;

import com.example.chatapijee.model.User;

public interface InterfaceUserService {

    void createUser(User user);

    void getUser();

    void updateUser();

    void deleteUser();

    void save(User user);

    void getById(String name);
}
