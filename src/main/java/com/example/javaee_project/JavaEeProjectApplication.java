package com.example.javaee_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class JavaEeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaEeProjectApplication.class, args);
    }
}
