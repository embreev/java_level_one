package ru.breev.se.mychat.server.api;

import ru.breev.se.mychat.server.model.Contact;
import ru.breev.se.mychat.server.model.ContactBox;

public interface ContactService {

    ContactBox contacts(String login);

    Contact create(String source, String target);

    void remove(String source, String target);

    void removeAll(String login);

}
