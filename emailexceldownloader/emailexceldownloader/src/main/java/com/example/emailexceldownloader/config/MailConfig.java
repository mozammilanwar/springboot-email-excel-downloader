package com.example.emailexceldownloader.config;

import jakarta.mail.Session;
import jakarta.mail.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public Store mailStore() throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", "mozammilanwar66@gmail.com", "qkwz dhwm dnvu tdep");
        return store;
    }
}
