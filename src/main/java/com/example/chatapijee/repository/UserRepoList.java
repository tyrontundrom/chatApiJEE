package com.example.chatapijee.repository;

import com.example.chatapijee.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepoList {


    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String name) {
        int userIndex = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(name)) {
                userIndex = i;
            }
        }
        return users.get(userIndex);
    }

    public void show() {
        users.forEach(System.out::println);
    }
}
