package client;

import java.util.Scanner;

public class MessageHandler {
    public static void sendToUser(String username) {
        System.out.println("Enter message receiver");
        Scanner scanner = new Scanner(System.in);
        String receiver = scanner.nextLine();
        System.out.println("Enter message text");
        String message = scanner.nextLine();
        Handlers.privateMessage(receiver, message, username);
    }


    public static void broadcast(String username) {
        System.out.println("Enter message text");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        Handlers.sendMessage( message, username);
    }

    public static void sendFile(String username) {
        System.out.println("Enter file path");
        System.out.println("path example: C:/Users/user/Desktop/MyFile.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Enter file name");
        System.out.println("file name example: MyFile.txt");
        String name = scanner.nextLine();
        System.out.println("Enter receiver name");
        String receiver = scanner.nextLine();
        Handlers.sendFile(path, name, receiver, username);
    }

    public static void getHistoryFromChannel(String username) {
        System.out.println("Enter channel name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Handlers.history(name, username);
    }
}
