package com.ww.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MailSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailSystemApplication.class, args);
    }

}
