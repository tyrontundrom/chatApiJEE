package client;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import java.util.Scanner;

@WebServlet
@Slf4j
class Connect {

    public static final String QUIT_COMMAND = "q";
    public static final String PRIVATE_MESSAGE_COMMAND = "@";
    public static final String SEND_FILE_COMMAND = "#send";
    public static final String SAVE_FILE_COMMAND = "#save";
    public static final String SHOW_HISTORY_COMMAND = "#show";

    public static void main(String[] args) {
        Handlers handlers = new Handlers();
        Scanner inputName = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String name;
        System.out.print("Podaj imię: ");
        name = inputName.nextLine();
        handlers.newUser(name);
        System.out.println("Wyjście z czatu \"\\q\"" +
                "\nPrywatna wiadomość \"@\"nazwa użytkownika wiadomość" +
                "\nWysyłanie pliku \"#send\" nazwa pliku" +
                "\nOdbieranie pliku \"#save\"" +
                "\nHistoria \"#show\"");
        String fromConsole = input.nextLine();
        while (!fromConsole.equals(QUIT_COMMAND)) {
            handlers.sendMessage(fromConsole = input.nextLine());
            System.out.println(name + ": " + fromConsole);
            if (fromConsole.contains(PRIVATE_MESSAGE_COMMAND)) {
                handlers.privateMessage(fromConsole);
            } else if (fromConsole.contains(SEND_FILE_COMMAND)) {
                handlers.sendFile();
            } else if(fromConsole.contains(SAVE_FILE_COMMAND)) {
                handlers.saveFile();
            } else if (fromConsole.contains(SHOW_HISTORY_COMMAND)) {
                handlers.history();
            }
        }
    }


}
