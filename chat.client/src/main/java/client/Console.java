package client;

class Console {
    public static void readMessage(Action action, String username) {
        switch (action) {
            case PRIVATE_MESSAGE:
                MessageHandler.sendToUser(username);
                break;
            case PUBLIC_MESSAGE:
                MessageHandler.broadcast(username);
                break;
            case SEND_FILE:
                MessageHandler.sendFile(username);
                break;
            case HISTORY_CHANNEL:
                MessageHandler.getHistoryFromChannel(username);
                break;
        }
    }
}
