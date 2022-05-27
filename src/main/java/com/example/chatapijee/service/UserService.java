package com.example.chatapijee.service;

import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.InterfaceUserRepository;
import com.example.chatapijee.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
@Singleton
public class UserService implements InterfaceUserService {


//    private final InterfaceUserRepository repository;
    private final UserRepository repository;

    @Override
    public void createUser(User user) {

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

    @Override
    public void getById(String name) {
        repository.getById(name);
    }
}
