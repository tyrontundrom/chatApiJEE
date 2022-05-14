package client;

import client.rest.UserDto;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ClientResponse;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientImpl;
import org.jose4j.jwk.Use;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
class Client {
    public static void main(String[] args) {
//
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/chat");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("value: " + value);
        response.close();

        ResteasyClient client1 = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        ResteasyWebTarget target1 = client1.target("http://localhost:8080/chatApiJEE_war_exploded/api/user");
        UserDto user = new UserDto();
        user.setName("Damian");
        var response1 = target1.request()
                //.accept(MediaType.APPLICATION_XML_TYPE)
                .accept(BinaryMapper.MEDIA_TYPE)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON));
        log.info("create user: " + user);
    }
}
