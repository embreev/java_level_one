package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.*;
import ru.breev.se.mychat.server.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Set;

@WebService(endpointInterface = "ru.breev.se.mychat.server.api.ChatService")
public final class ChatServiceBean implements ChatService {

    private final UserService userService = new UserServiceBean();

    private final MessageService messageService = new MessageServiceBean(userService);

    private final SessionService sessionService = new SessionServiceBean(userService);

    private final ContactService contactService = new ContactServiceBean();

    @Override
    @WebMethod
    public boolean register(String login, String password) {
        return userService.register(login, password);
    }

    @Override
    @WebMethod
    public List<String> getListLogin() {
        return userService.getListLogin();
    }

    @Override
    @WebMethod
    public void createUser(String login, String password) {
        userService.createUser(login, password);
    }

    @Override
    @WebMethod
    public boolean isLoginExists(String login) {
        return userService.isLoginExists(login);
    }

    @Override
    @WebMethod
    public void removeUser(String login) {
        userService.removeUser(login);
        System.out.printf("User %s is deleted", login);
    }

    @Override
    @WebMethod
    public Session signIn(String login, String password) {
        return sessionService.signIn(login, password);
    }

    @Override
    @WebMethod
    public User getUser(Session session) { return sessionService.getUser(session); }

    @Override
    @WebMethod
    public void signOut(Session session) {
        sessionService.signOut(session);
    }

    @Override
    @WebMethod
    public List<Message> getMessages(final Session session) {
        final User user = sessionService.getUser(session);
        return messageService.getMessage(user.login);
    }

    @Override
    @WebMethod
    public void sendBroadCast(Session session, String text) {
        final User user = sessionService.getUser(session);
        messageService.sendBroadCast(user.login, text);
    }

    @Override
    @WebMethod
    public void sendMessage(Session session, String login, String text) {
        final User source = sessionService.getUser(session);
        final User target = userService.getUser(login);
        messageService.sendMessage(source.login, target.login, text);
    }

    @Override
    @WebMethod
    public void cleanMessage(Session session) {
        final User user = sessionService.getUser(session);
        messageService.cleanMessage(user.login);
    }

    @Override
    @WebMethod
    public ContactBox getAllContacts(Session session) {
        final User user = sessionService.getUser(session);
        return contactService.contacts(user.login);
    }

    @Override
    @WebMethod
    public Contact createContact(Session session, String login) {
        final User user = sessionService.getUser(session);
        return contactService.create(user.login, login);
    }

    @Override
    @WebMethod
    public void removeContact(Session session, String login) {
        final User user = sessionService.getUser(session);
        contactService.remove(user.login, login);
    }

    @Override
    @WebMethod
    public void removeAllContacts(Session session) {
        final User user = sessionService.getUser(session);
        contactService.removeAll(user.login);
    }
}
