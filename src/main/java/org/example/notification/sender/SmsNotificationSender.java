package org.example.notification.sender;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsSender")
public class SmsNotificationSender implements NotificationSender {

    private String gateway;

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @PostConstruct
    public void init() {
        System.out.println("SmsNotification init");
    }

    @Override
    public void send(String to, String message) {
        System.out.println("""
                Sending SMS
                Via: %s
                To: %s
                Message: %s
                """.formatted(gateway, to, message));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SmsNotification destroy");
    }
}
