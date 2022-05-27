package com.example.chatapijee.rest;

import com.example.chatapijee.model.User;
import com.example.chatapijee.repository.UserRepoList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("user")
public class UserController {

//    @Inject
//    private InterfaceUserService interfaceUserService;
    private static UserRepoList repo = new UserRepoList();

    @POST
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        repo.addUser(user);
        System.out.println("create user: " + user);
        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/user/" + name)).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User showUser(@PathParam("name")String name) {

        return repo.getUser(name);
    }

    @GET
    @Path("show")
    @Produces(MediaType.APPLICATION_JSON)
    public void showUsers() {
        repo.show();
    }



//    @POST
//    @Path("{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response save(@PathParam("name") String name) {
//        User user = new User();
//        user.setName(name);
//        interfaceUserService.save(user);
//        System.out.println("create user");
//        return Response.created(URI.create("http://localhost:8080/chatApiJEE_war_exploded/api/user" + name)).build();
//    }

//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response show(@PathParam("id") String name) {
//        interfaceUserService.getById(name);
//        return Response.ok().build();
//    }
}
