package com.example.bladebuilder.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SecurityConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager get() {

        UserDetails admin = User.withUsername("Grzesiu")
                .password(passwordEncoder.encode("123456"))
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(List.of(admin));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeHttpRequests()
                .requestMatchers("/user").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .cors()
                .and()
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout().permitAll();

        return http.build();
    }
}
