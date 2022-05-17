package client;

import client.rest.UserDto;
import domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Scanner;

@WebServlet
@Slf4j
class Connect {

    public static final String QUIT_COMMAND = "q";
    public static final String PRIVATE_MESSAGE_COMMAND = "@";
    public static final String SEND_FILE_COMMAND = "#send";
    public static final String SAVE_FILE_COMMAND = "save";
    public static final String SHOW_HISTORY_COMMAND = "#show";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.print("Podaj imię: ");
        name = input.nextLine();
        newUser(name);
        System.out.println("Wyjście z czatu \"\\q\"" +
                "\nPrywatna wiadomość \"@\"nazwa użytkownika wiadomość" +
                "\nWysyłanie pliku \"#send\" nazwa pliku" +
                "\nOdbieranie pliku \"#save\"" +
                "\nHistoria \"#show\"");
        String fromConsole = input.nextLine();
        while (!fromConsole.equals(QUIT_COMMAND)) {
            System.out.println(name + ": " + fromConsole);
            fromConsole = input.nextLine();
            if (fromConsole.contains(PRIVATE_MESSAGE_COMMAND)) {
                privateMessage(fromConsole);
            } else if (fromConsole.contains(SEND_FILE_COMMAND)) {
                sendFile();
            } else if(fromConsole.contains(SAVE_FILE_COMMAND)) {
                saveFile();
            } else if (fromConsole.contains(SHOW_HISTORY_COMMAND)) {
                history();
            }
        }
    }

    private static void newUser(String name) {
        ResteasyClient client = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        UserDto user = new UserDto();
        user.setName(name);
        ResteasyWebTarget target1 = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/user/");
        var response1 = target1.request()
                //.accept(MediaType.APPLICATION_XML_TYPE)
                .accept(BinaryMapper.MEDIA_TYPE)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON));
        log.info("new user: " + user);
    }

    private static void history() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/message/history");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("history: " + value);
        response.close();
    }

    private static void saveFile() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/chatApiJEE_war_exploded/api/file/download");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        log.info("value: " + value);
        response.close();
    }

    private static void sendFile() {
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

    private static void privateMessage(String fromConsole) {
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
