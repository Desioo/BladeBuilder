package com.example.bladebuilder.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager get() {
        UserDetails admin = User.withUsername("Grzesiu")
                .password("1234")
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("user")
                .password("user1")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(List.of(user, admin));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeHttpRequests()
                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout().permitAll();

        return http.build();
    }
}
