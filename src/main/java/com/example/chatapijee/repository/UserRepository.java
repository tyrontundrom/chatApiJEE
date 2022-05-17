package com.example.chatapijee.repository;


import com.example.chatapijee.model.User;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Singleton
public class UserRepository implements InterfaceUserRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Optional<User> getById(String name) {
        return Optional.ofNullable(entityManager.find(User.class, name));
    }

}
