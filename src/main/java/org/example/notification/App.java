package org.example.notification;

import org.example.notification.service.NotificationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml")){

            var service = context.getBean("notificationService", NotificationService.class);
            service.notify("ashish.s@gmail.com", "Your account has been activated.");
        }
    }
}
