package ru.breev.se.mychat.server.service;

import ru.breev.se.mychat.server.api.MessageService;
import ru.breev.se.mychat.server.api.UserService;
import ru.breev.se.mychat.server.model.Message;
import ru.breev.se.mychat.server.model.MessageBox;

import java.lang.ref.SoftReference;
import java.util.*;

public class MessageServiceBean implements MessageService {
    private final Map<String, MessageBox> boxes = new HashMap<>();
    private final UserService userService;


    public MessageServiceBean(final UserService userService) {
        this.userService = userService;
    }

    private MessageBox getMessageBox(final String login) {
        if (login == null || login.isEmpty()) return null;
        if (!boxes.containsKey(login)) boxes.put(login, new MessageBox());
        return boxes.get(login);
    };

    @Override
    public List<Message> getMessage(final String login) {
        final MessageBox messageBox = getMessageBox(login);
        cleanMessage(login);
        return messageBox;
    }

    @Override
    public void sendBroadCast(String source, String text) {
        final Collection<String> logins = userService.getListLogin();
        for (final String target: logins) {
            if (source.equals(target)) continue;
            sendMessage(source, target, text);
        }

    }

    @Override
    public void sendMessage(final String source, final String target, final String text) {
        final Message message = new Message();
        message.source = source;
        message.target = target;
        message.text = text;
        final MessageBox messageBox = getMessageBox(target);
        messageBox.add(message);
    }

    @Override
    public void cleanMessage(final String login) {
        boxes.put(login, new MessageBox());
    }
}
