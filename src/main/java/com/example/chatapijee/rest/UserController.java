package com.example.chatapijee.rest;

import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.UserRepository;
import com.example.chatapijee.service.InterfaceUserService;
import com.example.chatapijee.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("user")
public class UserController {

    @Inject
    private InterfaceUserService interfaceUserService;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(User user) {
        interfaceUserService.save(user);
        System.out.println("create user");
        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/user")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") String name) {
        interfaceUserService.getById(name);
        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/user/id")).build();
    }
}
