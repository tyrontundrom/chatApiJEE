package com.example.chatapijee.service;

import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.InterfaceUserRepository;
import com.example.chatapijee.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class UserService implements InterfaceUserService {

    private final InterfaceUserRepository repository;

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
    public void save(User user) {
        repository.save(user);
    }
}
