package com.example.chatapijee.repository;

import com.example.chatapijee.model.Message;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

class MessageRepository implements InterfaceMessageRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Message message) {
        entityManager.persist(message);
    }

    @Override
    public List<Message> getMessages() {
        return entityManager.createQuery("SELECT m FROM Message m", Message.class).getResultList();
    }

    @Override
    public void getById(Long id) {
        entityManager.find(Message.class, id);
    }
}
