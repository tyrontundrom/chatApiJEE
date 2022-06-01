package com.example.chatapijee.rest;

import com.example.chatapijee.dto.PrivateMessageDto;
import com.example.chatapijee.dto.PublicMessageDto;
import com.example.chatapijee.repository.MessageRepoList;
import com.example.chatapijee.service.ChatService;
import com.example.chatapijee.service.JmsMessageService;
import com.sun.istack.NotNull;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("messages")
public class MessageController {

//    @Inject
//    private InterfaceMessageService interfaceMessageService;
    private static MessageRepoList repoList = new MessageRepoList();

    @Inject
    private ChatService chatService;

    @POST
    @Path("/message")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PublicMessageDto publicMessageDto, @HeaderParam("username") String username) {
        publicMessageDto.setSender(username);
        chatService.send(publicMessageDto);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/private")
    public Response sendPrivateMessage(PrivateMessageDto privateMessageDto,
                                       @NotNull @HeaderParam("username") String userName) {
        privateMessageDto.setSender(userName);
        chatService.sendToUser(privateMessageDto);
        return Response.ok().build();
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
