package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.UserService;
import ru.breev.se.mychat.server.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceBean implements UserService {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public boolean register(final String login, final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        if (users.containsKey(login)) return false;
        createUser(login, password);
        return true;
    }

    @Override
    public List<String> getListLogin() {
        return new ArrayList<>(users.keySet());
    }

    @Override
    public void createUser(final String login, final String password) {
        if (login == null || login.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        if (users.containsKey(login)) return;
        final User user = new User();
        user.login = login;
        user.password = password;
        users.put(login, user);

    }

    @Override
    public User getUser(final String login) {
        if (login == null || login.isEmpty()) return null;
        return users.get(login);
    }

    @Override
    public int getCountUser() {
        return users.size();
    }

    @Override
    public void removeAll() {
        users.clear();
    }

    @Override
    public boolean isLoginExists(final String login) {
        return users.containsKey(login);
    }

    @Override
    public void removeUser(final String login) {
        users.remove(login);
    }
}
