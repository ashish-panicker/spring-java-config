package org.example.notification;

import org.example.notification.config.AppConfig;
import org.example.notification.config.ConfigWithStereoTypes;
import org.example.notification.service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigWithStereoTypes.class)){
            var service = context.getBean(NotificationService.class);
            service.notify("ashish.s@gmail.com", "Your account activation request has been collected.");
        }
    }
}
