package org.example.notification.service;

import org.example.notification.sender.NotificationSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    private final NotificationSender sender;

    public NotificationService(@Qualifier("emailSender") NotificationSender sender) {
        this.sender = sender;
    }

    public void notify(String to, String message) {
        sender.send(to, message);
    }
}
