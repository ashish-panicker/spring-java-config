package org.example.notification.sender;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class EmailNotificationSender implements NotificationSender {

    private String fromAddress;

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    @PostConstruct
    public void init() {
        System.out.println("EmailNotificationSender init");
    }

    @Override
    public void send(String to, String message) {
        System.out.println("""
                Sending Email
                From: %s
                To: %s
                Message: %s
                """.formatted(fromAddress, to, message));

    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailNotificationSender destroyed");
    }
}
