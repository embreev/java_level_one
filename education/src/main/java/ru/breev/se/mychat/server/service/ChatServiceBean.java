package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.ChatService;
import ru.breev.se.mychat.server.api.MessageService;
import ru.breev.se.mychat.server.api.SessionService;
import ru.breev.se.mychat.server.api.UserService;
import ru.breev.se.mychat.server.model.Message;
import ru.breev.se.mychat.server.model.Session;
import ru.breev.se.mychat.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.breev.se.mychat.server.api.ChatService")
public final class ChatServiceBean implements ChatService {

    private final UserService userService = new UserServiceBean();

    private final MessageService messageService = new MessageServiceBean(userService);

    private final SessionService sessionService = new SessionServiceBean(userService);

    @WebMethod
    @Override
    public boolean register(String login, String password) {
        return userService.register(login, password);
    }

    @WebMethod
    @Override
    public List<String> getListLogin() {
        return userService.getListLogin();
    }

    @WebMethod
    @Override
    public void createUser(String login, String password) {
        userService.createUser(login, password);
    }

    @WebMethod
    @Override
    public boolean isLoginExists(String login) {
        return userService.isLoginExists(login);
    }

    @WebMethod
    @Override
    public void removeUser(String login) {
        userService.removeUser(login);
        System.out.printf("User %s is deleted", login);
    }

    @WebMethod
    @Override
    public Session signIn(String login, String password) {
        return sessionService.signIn(login, password);
    }

    @WebMethod
    @Override
    public User getUser(Session session) { return sessionService.getUser(session); }

    @WebMethod
    @Override
    public void signOut(Session session) {
        sessionService.signOut(session);
    }

    @WebMethod
    @Override
    public List<Message> getMessage(final Session session) {
        final User user = sessionService.getUser(session);
        return messageService.getMessage(user.login);
    }

    @WebMethod
    @Override
    public void sendBroadCast(Session session, String text) {
        final User user = sessionService.getUser(session);
        messageService.sendBroadCast(user.login, text);
    }

    @WebMethod
    @Override
    public void sendMessage(Session session, String login, String text) {
        final User source = sessionService.getUser(session);
        final User target = userService.getUser(login);
        messageService.sendMessage(source.login, target.login, text);
    }

    @WebMethod
    @Override
    public void cleanMessage(Session session) {
        final User user = sessionService.getUser(session);
        messageService.cleanMessage(user.login);
    }
}
