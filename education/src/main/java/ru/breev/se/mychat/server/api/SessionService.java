package ru.breev.se.mychat.server.api;

import ru.breev.se.mychat.server.model.Session;
import ru.breev.se.mychat.server.model.User;

public interface SessionService {

    Session signIn(String login, String password);

    User getUser(Session session);

    void  signOut(Session session);

}
