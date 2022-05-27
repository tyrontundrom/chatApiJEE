package com.example.chatapijee.rest;

import com.example.chatapijee.model.Message;
import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.MessageRepoList;
import com.example.chatapijee.service.InterfaceMessageService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("messages")
public class MessageController {

//    @Inject
//    private InterfaceMessageService interfaceMessageService;
    private static MessageRepoList repoList = new MessageRepoList();

    @POST
    @Path("{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("message") String message) {
        Message messageObj = new Message();
        messageObj.setMessage(message);
        repoList.addMessage(messageObj);
        System.out.println("new message: " + message);
        return Response.ok().entity(messageObj.toString()).build();
    }


    @GET
    @Path("history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showHistory() {
        repoList.show();
        return Response.ok(repoList.toString()).build();
    }

    @GET
    @Path("one")
    @Produces(MediaType.APPLICATION_JSON)
    public Response one() {
        return Response.ok(repoList.show()).build();
    }
}
