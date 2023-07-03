package com.example.bladebuilder.conf;

import com.example.bladebuilder.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

//    @Bean
//    public InMemoryUserDetailsManager get() {
//
////        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
//
//        UserDetails admin = User.withUsername("Grzesiu")
//                .password(passwordEncoder.encode("123456"))
//                .roles("ADMIN")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(List.of(admin));
//    }

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

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }


}
