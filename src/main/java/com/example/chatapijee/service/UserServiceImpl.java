package com.example.chatapijee.service;

import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.InterfaceUserRepository;

class UserServiceImpl implements UserService {

    private final InterfaceUserRepository repository;

    UserServiceImpl(InterfaceUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser() {

    }

    @Override
    public void getUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void addUser(User user) {
        repository.addUser(user);
    }
}
