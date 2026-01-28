package org.example.notification.sender;

public class EmailNotificationSender implements NotificationSender {

    private String fromAddress;

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

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

    public void destroy() {
        System.out.println("EmailNotificationSender destroyed");
    }
}
