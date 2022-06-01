package com.example.chatapijee.model;

import lombok.Data;

//@Entity
@Data
public class FileModel {
//    @Id
//    @GeneratedValue
    private long id;
    private String name;
    private byte[] bytes;
    private String receiver;
}
