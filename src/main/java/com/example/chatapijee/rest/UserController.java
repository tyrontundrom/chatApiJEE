package com.example.chatapijee.rest;

import com.example.chatapijee.model.User;
import com.example.chatapijee.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("user")
public class UserController {

    @Inject
    private UserService userService;


    @POST
    @Produces("application/json")
    public Response createUser(User user) {
        userService.addUser(user);
        System.out.println("create user");
        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/user")).build();
    }
}
