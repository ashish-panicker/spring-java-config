package org.example.notification.config;

import org.example.notification.sender.EmailNotificationSender;
import org.example.notification.sender.NotificationSender;
import org.example.notification.sender.SmsNotificationSender;
import org.example.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration // lets spring know this is a java configuration class
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public NotificationSender smsSender(@Value("sms.gateway") String gateway) {
        var sender =  new SmsNotificationSender();
        sender.setGateway(gateway);
        return sender;
    }

    @Bean
    @Primary
    public NotificationSender emailSender(@Value("from.email") String fromEmail) {
        var sender =  new EmailNotificationSender();
        sender.setFromAddress(fromEmail);
        return sender;
    }

    @Bean
    public NotificationService notificationService(NotificationSender sender) {
        return new NotificationService(sender);
    }

    /**
     * Error creating bean with name 'notificationService' defined in org.example.notification.config.AppConfig:
     * Unsatisfied dependency expressed through method 'notificationService' parameter 0: No qualifying bean of
     * type 'org.example.notification.sender.NotificationSender' available:
     * expected single matching bean but found 2: smsSender,emailSender
     */
}
