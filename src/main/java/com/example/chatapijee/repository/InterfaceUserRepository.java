package com.example.chatapijee.repository;


import com.example.chatapijee.model.User;

import java.util.Optional;

public interface InterfaceUserRepository {

    User save(User user);

    Optional<User> getById(String name);
}
