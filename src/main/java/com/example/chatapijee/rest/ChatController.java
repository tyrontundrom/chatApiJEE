package com.example.chatapijee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
