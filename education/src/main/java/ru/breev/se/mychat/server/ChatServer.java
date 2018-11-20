package ru.breev.se.mychat.server;

import ru.breev.se.mychat.server.api.ChatService;
import ru.breev.se.mychat.server.service.ChatServiceBean;

import javax.xml.ws.Endpoint;

public class ChatServer {
    public static void main(String[] args) {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("user", "user");
        Endpoint.publish("http://localhost:8080/ChatService?wsdl", service);
    }
}
