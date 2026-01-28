package org.example.notification.sender;

public class SmsNotificationSender implements NotificationSender {

    private String gateway;

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

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

    public void destroy() {
        System.out.println("SmsNotification destroy");
    }
}
