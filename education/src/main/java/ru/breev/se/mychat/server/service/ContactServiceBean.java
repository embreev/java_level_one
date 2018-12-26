package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.ContactService;
import ru.breev.se.mychat.server.model.Contact;
import ru.breev.se.mychat.server.model.ContactBox;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ContactServiceBean implements ContactService {

    private Map<String, ContactBox> contacts = new LinkedHashMap<>();

    @Override
    public ContactBox contacts(String login) {
        if (login == null || login.isEmpty()) return null;
        if (!contacts.containsKey(login)) contacts.put(login, new ContactBox());
        return contacts.get(login);
    }

    @Override
    public Contact create(String source, String target) {
        if (source == null || source.isEmpty()) return null;
        if (target == null || target.isEmpty()) return null;
        final Contact contact = new Contact();
        contact.source = source;
        contact.target = target;
        contacts(source).add(contact);
        return contact;
    }

    @Override
    public void remove(final String source, final String target) {
        if (source == null || source.isEmpty()) return;
        if (target == null || target.isEmpty()) return;
        final ContactBox contacts = contacts((source));
        contacts.removeIf(e-> e.source.equals(source) && e.target.equals(target));
    }

    @Override
    public void removeAll(String login) {
        if (login == null || login.isEmpty()) return;
        contacts.put(login, new ContactBox());
    }
}
