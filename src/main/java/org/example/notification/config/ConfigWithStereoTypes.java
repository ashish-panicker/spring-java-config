package org.example.notification.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"org.example.notification.sender", "org.example.notification.service"})
public class ConfigWithStereoTypes {
}
