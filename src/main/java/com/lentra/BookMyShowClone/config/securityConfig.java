package com.lentra.BookMyShowClone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( req -> req.requestMatchers("/", "login", "register")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic( Customizer.withDefaults() )
                .sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
                .build();
    };

}
