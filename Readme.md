# Notification Management System

## Objective

Build a notification management system using **Spring Core** that demonstrates
- Inversion of Control
- Dependency Injection
- Bean Scopes
- Bean Lifecycle Callbacks
- Qualifiers/Primary beans
- Externalised configuration
- XML and Java based configuration styles

## Scenario

An enterprise application needs to send notifications through multiple channels, namely:
- Email
- SMS
- Push Notification

Build a **Notification Service** that would:
- Decide which notification to use
- Be loosley couple to sender implementations
- Allow easy switching of implementations based on configurations

## Requirements

1. The system must support multiple notification channels
2. Switching notification types must not require code changes
3. Notification senders must be managed by spring
4. Notification Service must not create objects
5. Sender implementations must support lifecycle callbacks
6. Configurations must be implemented using
    - Java based
    - XML based

## Core Components

### Notification Sender

```java
public interface NotificationSender {
    void send(String to, String message);
}
```

**Implementations**
- `EmailNotificationSender`
- `SmsNotificationSender`
- `PushNotificationSender`

**Each Implementation Must**
- Log when initialized
- Log when destroyed
- Accept configuration values

### NFR

Dependency Injection
- Constructor + Setter

IoC Container
- `ApplicationContext`

Bean Scope
- Singleton
- Prototype

Lifecycle Hooks
- `init-method` & `destroy-method`
- `@PostConstruct` & `@PreDestroy`

## XML Based Config

1. Define all beans in `beans.xml`
2. Inject dependencies using `constructor injection` and `setter injection`
3. Configure `init-method` and `destroy-method`
4. Externalise values using `PropertyPlaceHolderConfigurer`
5. Switch between Email/SMS sender only via XML
6. Test `Singleton` and `Prototype` scopes

## Java Based Config

1. Replace XML with `@Configuration`
2. Define beans using `@Bean` or stereotype annotations
3. Use `@Primary` and `@Qualifier`
4. Externalize configuration using `@PropertySource`
5. Implement lifecycle callbacks