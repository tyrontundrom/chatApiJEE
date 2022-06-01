package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class Handlers {

    public void newUser(String name) {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/user/" + name);
        Response response = target.request().post(Entity.entity(name, MediaType.APPLICATION_JSON));
        String value = response.readEntity(String.class);
        log.info("user: " + name);
        response.close();
    }

    public static void sendMessage(String message, String username) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/chatApiJEE_war_exploded/api/messages/message");
        httpPost.setEntity(new StringEntity(String.format("{\"message\":\"%s\"}", message), ContentType.APPLICATION_JSON));
        httpPost.setHeader("username", username);
        try {
            HttpEntity entity = client.execute(httpPost).getEntity();
            System.out.println(EntityUtils.toString(entity, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void history(String name, String username) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/chatApiJEE_war_exploded/api/messages/history/" + name);
        httpGet.setHeader("username", username);
        try {
            HttpEntity entity = client.execute(httpGet).getEntity();
            String message = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            List<ChannelHistoryDto> history = objectMapper.readValue(message, new TypeReference<List<ChannelHistoryDto>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
            history.forEach(item -> System.out.println(String.format("From: %S | channel: %s | message: %s", item.getSender(), item.getChannel(), item.getMessage())));
            System.out.println(EntityUtils.toString(entity, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void saveFile() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/file/download");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("value: " + value);
        response.close();
    }

    public static void sendFile(String path, String name, String receiver, String username) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/chatApiJEE_war_exploded/api/file");
        httpPost.setEntity(new StringEntity(String.format("{\n" +
                "    \"receiver\":\"%s\",\n" +
                "    \"name\":\"%s\",\n" +
                "    \"path\":\"%s\"\n" +
                "}", receiver, name, path), ContentType.APPLICATION_JSON));
        httpPost.setHeader("username", username);
        try {
            HttpEntity entity = client.execute(httpPost).getEntity();
            System.out.println(EntityUtils.toString(entity, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void privateMessage(String receiver, String message, String username) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/chatApiJEE_war_exploded/api/messages/private");
        httpPost.setEntity(new StringEntity(String.format("{\n" +
                "    \"message\":\"%s\",\n" +
                "    \"receiver\":\"%s\"\n" +
                "}", message, receiver), ContentType.APPLICATION_JSON));
        httpPost.setHeader("username", username);
        try {
            HttpEntity entity = client.execute(httpPost).getEntity();
            System.out.println(EntityUtils.toString(entity, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
