package ru.breev.se.mychat.server.api;

import ru.breev.se.mychat.server.model.User;

import java.util.List;

public interface UserService {

    boolean register(String login, String password);

    List<String> getListLogin();

    void createUser(String login, String password);

    User getUser(String login);

    int getCountUser();

    void removeAll();

    boolean isLoginExists(String login);

    void removeUser(String login);

}
