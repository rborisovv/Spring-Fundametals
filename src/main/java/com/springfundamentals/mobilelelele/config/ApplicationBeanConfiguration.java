package com.springfundamentals.mobilelelele.config;

import com.springfundamentals.mobilelelele.session.UserSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    @SessionScope
    public UserSession userSession() {
        return new UserSession();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}