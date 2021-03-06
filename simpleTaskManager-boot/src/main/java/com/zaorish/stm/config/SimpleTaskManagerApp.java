package com.zaorish.stm.config;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfig.class, PersistenceConfig.class, ServiceConfig.class})
public class SimpleTaskManagerApp {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SimpleTaskManagerApp.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}
