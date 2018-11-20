package ru.breev.se.mychat.server.api;

import ru.breev.se.mychat.server.model.Message;
import ru.breev.se.mychat.server.model.Session;
import ru.breev.se.mychat.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ChatService {

    @WebMethod
    boolean register(@WebParam String login, @WebParam String password);

    @WebMethod
    List<String> getListLogin();

    @WebMethod
    void createUser(@WebParam String login, @WebParam String password);

    @WebMethod
    boolean isLoginExists(@WebParam String login);

    @WebMethod
    void removeUser(@WebParam String login);

    @WebMethod
    Session signIn(@WebParam String login, @WebParam String password);

    @WebMethod
    User getUser(@WebParam Session session);

    @WebMethod
    void  signOut(@WebParam Session session);

    @WebMethod
    List<Message> getMessage(@WebParam Session session);

    @WebMethod
    void sendBroadCast(@WebParam Session session, @WebParam String text);

    @WebMethod
    void sendMessage(@WebParam Session session, @WebParam String login, @WebParam String text);

    @WebMethod
    void cleanMessage(@WebParam Session session);

}
