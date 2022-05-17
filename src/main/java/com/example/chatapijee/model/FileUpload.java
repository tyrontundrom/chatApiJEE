package com.example.chatapijee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @Lob
    private byte[] data;

}
