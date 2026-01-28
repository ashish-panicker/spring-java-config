package org.example.notification.service;

import org.example.notification.sender.NotificationSender;

public class NotificationService {

    private final NotificationSender sender;

    public NotificationService(NotificationSender sender) {
        this.sender = sender;
    }

    public void notify(String to, String message) {
        sender.send(to, message);
    }
}
