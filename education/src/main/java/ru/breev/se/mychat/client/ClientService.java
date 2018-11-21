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
    private static final String CMD_REGISTER = "register";
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
            System.out.print("Enter command, for help enter help\n");
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
                case CMD_REGISTER:
                    register();
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
        System.out.print("### COMMANDS\n");
        System.out.print("### Login to chat: login\n");
        System.out.print("### Log out from chat: logout\n");
        System.out.print("### Registration new user: register\n");
        System.out.print("### Send a private message to the user: send\n");
        System.out.print("### Send message to all user: broadcast\n");
        System.out.print("### Read message: read\n");
        System.out.print("### Viewe list of all users: users\n");
    }

    private void login() {
        System.out.print("Enter login:\n");
        final String login = scanner.nextLine();
        System.out.print("Enter password:\n");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = (session == null) ? "ERROR" : "OK";
        System.out.printf("Auth: %s\n", msg);
    }

    private void logout() {
        chatService.signOut(session);
    }

    private void register() {
        System.out.print("Enter login:\n");
        final String login = scanner.nextLine();
        System.out.print("Enter password:\n");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        if (session == null && chatService.register(login, password)) System.out.print("User created successfully\n");
        else System.out.print("User exists or error create user");
    }

    private void read() {
        final List<Message> messages = chatService.getMessages(session);
        for (final Message message: messages) {
            System.out.print("New incoming message!\n");
            System.out.printf("From: %s\n", message.source);
            System.out.printf("Text: %s\n", message.text);
        }
    }

    private void send() {
        System.out.print("Enter the Recipient login:\n");
        final String login = scanner.nextLine();
        System.out.print("Enter message:\n");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }

    private void users() {
        System.out.printf("Users:\n%s\n", chatService.getListLogin());
    }

    private void broadcast() {
        System.out.print("Enter message:\n");
        final String message = scanner.nextLine();
        chatService.sendBroadCast(session, message);
    }
}
