package com.example.chatapijee.repository;


import com.example.chatapijee.model.User;

import java.util.HashMap;
import java.util.Map;

class UserRepository implements InterfaceUserRepository {
    private Map<Integer, User> users = new HashMap<>();
    private Integer id;

    @Override
    public void addUser(User user) {
        users.put(nextId(),user);
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    private Integer nextId() {
        return id++;
    }
}
