package client;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class Client {
    public static void main(String[] args) {
        var restClient = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        var chat = restClient.target("http://localhost:8080/chatApiJEE_war_exploded/api/chat/name");
        Response response = (Response) chat.request()
                //.accept(MediaType.APPLICATION_XML_TYPE)
                .accept(BinaryMapper.MEDIA_TYPE);
        System.out.println("### Response: " + response.getStatus());
    }
}
