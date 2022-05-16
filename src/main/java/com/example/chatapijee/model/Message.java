package com.example.chatapijee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
}
