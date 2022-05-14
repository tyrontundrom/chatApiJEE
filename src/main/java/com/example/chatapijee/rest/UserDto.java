package com.example.chatapijee.rest;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "user")
@Data
class UserDto implements Serializable {
    private Long id;
    private String name;
}
