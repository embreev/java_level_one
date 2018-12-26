package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.SessionService;
import ru.breev.se.mychat.server.api.UserService;
import ru.breev.se.mychat.server.model.Session;
import ru.breev.se.mychat.server.model.User;

import java.util.HashMap;
import java.util.Map;

public class SessionServiceBean implements SessionService {
    private final UserService userService;
    private final Map<Session, User> sessions = new HashMap<>();

    public SessionServiceBean(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Session signIn(String login, String password) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        final User user = userService.getUser(login);
        if (user == null) return null;
        if (!user.password.equals(password)) return null;
        final Session session = new Session();
        sessions.put(session, user);
        return session;
    }

    @Override
    public User getUser(Session session) {
        if (session == null) return null;
        return sessions.get(session);
    }

    @Override
    public void signOut(Session session) {
        if (session == null) return;
        sessions.remove(session);
    }
}
