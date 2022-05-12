package com.example.chatapijee.rest;

import com.example.chatapijee.model.User;
import com.example.chatapijee.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("chat")
//@Setter
//@RequiredArgsConstructor
public class ChatController {

    @GET
//    @Path("/name")
    public String getName() {
        System.out.println("name");
       return "Mike";
    }


}
