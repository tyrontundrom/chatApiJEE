package com.example.chatapijee.service;

import com.example.chatapijee.model.User;

public interface UserService {

    void createUser();

    void getUser();

    void updateUser();

    void deleteUser();

    void addUser(User user);
}
