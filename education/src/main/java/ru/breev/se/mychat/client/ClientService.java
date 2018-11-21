package ru.breev.se.mychat.client;

import ru.breev.se.mychat.server.api.ChatService;
import ru.breev.se.mychat.server.model.Message;
import ru.breev.se.mychat.server.model.Session;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    private static final String CMD_EXIT = "exit";
    private static final String CMD_LOGIN = "login";
    private static final String CMD_LOGOUT = "logout";
    private static final String CMD_READ = "read";
    private static final String CMD_SEND = "send";
    private static final String CMD_USERS = "users";
    private static final String CMD_BROADCAST = "broadcast";
    private static final String CMD_HELP = "help";
    private static final String LOCAL_PART = "ChatServiceBeanService";
    private static final String LOCAL_NAMESPACE = "http://service.server.mychat.se.breev.ru/";
    private static final String WSDL = "http://localhost:8080/ChatService?wsdl";

    private final URL ulr;
    private final QName qname;
    private final Service service;
    private final ChatService chatService;
    private final Scanner scanner;
    private Session session = null;

    public ClientService() throws Exception {
        ulr = new URL(WSDL);
        qname = new QName(LOCAL_NAMESPACE, LOCAL_PART);
        service = Service.create(ulr, qname);
        chatService = service.getPort(ChatService.class);
        scanner = new Scanner(System.in);
    }

    public void run() {
        String cmd = "";
        while (!CMD_EXIT.equals(cmd)) {
            System.out.printf("Enter command, for help enter help\n");
            cmd = scanner.nextLine();
            switch (cmd) {
                case CMD_EXIT:
                    break;
                case CMD_LOGIN:
                    login();
                    break;
                case CMD_LOGOUT:
                    logout();
                    break;
                case CMD_READ:
                    read();
                    break;
                case CMD_SEND:
                    send();
                    break;
                case CMD_USERS:
                    users();
                    break;
                case CMD_BROADCAST:
                    broadcast();
                    break;
                case CMD_HELP:
                    printCommand();
                    break;
            }
        }

    }

    private void printCommand() {
        System.out.printf("### Help commands ###\n");
        System.out.printf("### Login to chat: login ###\n");
        System.out.printf("### Log out from chat: logout ###\n");
        System.out.printf("### Send a private message to the user: send ###\n");
        System.out.printf("### Send message to all user: broadcast ###\n");
        System.out.printf("### Read message: read ###\n");
        System.out.printf("### Viewe list of all users: users ###\n");
    }

    private void login() {
        System.out.printf("Enter login:\n");
        final String login = scanner.nextLine();
        System.out.printf("Enter password:\n");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = (session == null) ? "OK" : "ERROR";
        System.out.printf("Auth: %s\n", msg);
    }

    private void logout() {
        chatService.signOut(session);
    }

    private void read() {
        final List<Message> messages = chatService.getMessages(session);
        for (final Message message: messages) {
            System.out.printf("New incoming message!\n");
            System.out.printf("From: %s\n", message.source);
            System.out.printf("Text: %s\n", message.text);
        }
    }

    private void send() {
        System.out.printf("Enter the Recipient login:\n");
        final String login = scanner.nextLine();
        System.out.printf("Enter message:\n");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }

    private void users() {
        chatService.getListLogin();
    }

    private void broadcast() {
        System.out.printf("Enter message:\n");
        final String message = scanner.nextLine();
        chatService.sendBroadCast(session, message);
    }
}
