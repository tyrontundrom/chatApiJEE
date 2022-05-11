package com.example.chatapijee.rest;

import com.example.chatapijee.model.User;
import com.example.chatapijee.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("chat")
@Setter
@RequiredArgsConstructor
class ChatController {

    @Inject
    private ChatService chatService;
//    private User name;

//    @POST
//    public Response save() {
//        name.setId(1L);
//        name.setName("Mike");
//        return Response.ok().build();
//    }

    @GET
    @Path("/name")
    public String getName() {
       return "Mike";
    }
}
