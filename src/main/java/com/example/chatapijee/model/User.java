package com.example.chatapijee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class User {
    @Id
    private Long id;
    private String name;
}
