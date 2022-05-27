package client;

import client.BinaryMapper;
import client.rest.UserDto;
import domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
class Handlers {

    public void newUser(String name) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/user/" + name);
        Response response = target.request().post(Entity.entity(name,MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        log.info("user: " + name);
        response.close();
//        ResteasyClient client = new ResteasyClientBuilderImpl()
//                .register(BinaryMapper.class)
//                .build();
//        UserDto user = new UserDto();
//        user.setName(name);
//        ResteasyWebTarget target1 = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/user/"+ name);
//        var response1 = target1.request()
//                //.accept(MediaType.APPLICATION_XML_TYPE)
//                .accept(BinaryMapper.MEDIA_TYPE)
//                .post(Entity.entity(name, MediaType.APPLICATION_JSON));
//        response1.readEntity(String.class);
//        log.info("new user: " + user);
    }

    public void sendMessage(String message) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        String urlAddress = "http://localhost:8080/chatApiJEE_war_exploded/api/messages/" + message;
        WebTarget target = client.target(urlAddress);
        Response response = target.request().post(Entity.entity(message, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        log.info("message: " + message);
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        response.close();
    }

    public void history() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/messages/history");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("history: " + value);
        response.close();
    }

    public void saveFile() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/file/download");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("value: " + value);
        response.close();
    }

    public void sendFile() {
        ResteasyClient client = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        File file = new File("");
        ResteasyWebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/file/upload");
        var response1 = target.request()
                //.accept(MediaType.APPLICATION_XML_TYPE)
                .accept(BinaryMapper.MEDIA_TYPE)
                .post(Entity.entity(file, MediaType.APPLICATION_JSON));
        log.info("send file: " + file);
    }

    public void privateMessage(String fromConsole) {
        ResteasyClient client = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        Message message = new Message(fromConsole);
        ResteasyWebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/user/id");
        var response = target.request()
                .accept(BinaryMapper.MEDIA_TYPE)
                .post(Entity.entity(message, MediaType.APPLICATION_JSON));
        log.info("message:  " + message);
    }
}
