package client;

import model.User;
import org.jose4j.jwk.Use;

import javax.servlet.annotation.WebServlet;
import java.util.Scanner;

@WebServlet
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
                privateMessage();
            } else if (fromConsole.contains(SEND_FILE_COMMAND)) {
                sendFile();
            } else if(fromConsole.contains(SAVE_FILE_COMMAND)) {
                saveFile();
            } else if (fromConsole.contains(SHOW_HISTORY_COMMAND)) {
                history();
            }
        }
    }

    private static void history() {
        System.out.println("history");
    }

    private static void saveFile() {
        System.out.println("save");
    }

    private static void sendFile() {
        System.out.println("send");
    }

    private static void privateMessage() {
        System.out.println("privat");
    }
}
