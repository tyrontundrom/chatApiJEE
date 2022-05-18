package com.example.chatapijee.rest;

import com.example.chatapijee.model.Message;
import com.example.chatapijee.model.User;
import com.example.chatapijee.service.InterfaceMessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("message")
public class MessageController {

    @Inject
    private InterfaceMessageService interfaceMessageService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Message message) {
        interfaceMessageService.save(message);
        System.out.println("create message");
        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/message")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) {
        interfaceMessageService.getById(id);
        return Response.ok().build();
    }

    @GET
    @Path("history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showHistory() {
        interfaceMessageService.getMessages();
        return Response.ok().build();
    }
}
