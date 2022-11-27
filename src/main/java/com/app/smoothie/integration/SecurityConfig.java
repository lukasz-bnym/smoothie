package com.app.smoothie.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.builder();
        UserDetails user = users
            .username("user")
            .password("{noop}user_password")
            .roles("USER")
            .build();
        UserDetails owner = users
            .username("owner")
            .password("{noop}owner_password")
            .roles("USER", "BUSINESS_OWNER")
            .build();
        return new InMemoryUserDetailsManager(user, owner);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .httpBasic()
            .and()
            .build();
    }
}
