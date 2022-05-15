package com.example.chatapijee.service;

import com.example.chatapijee.model.User;

public interface InterfaceUserService {

    void createUser();

    void getUser();

    void updateUser();

    void deleteUser();

    void save(User user);
}
