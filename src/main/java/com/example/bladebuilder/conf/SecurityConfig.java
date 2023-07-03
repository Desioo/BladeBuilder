package com.example.bladebuilder.conf;

import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.repository.UserRepository;
import com.example.bladebuilder.service.UserDetailsServiceImpl;
import jakarta.annotation.PostConstruct;
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

    @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            // Tworzenie roli "Admin" (jeśli nie istnieje)
//            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//            if (adminRole == null) {
//                adminRole = new Role("ROLE_ADMIN");
//                roleRepository.save(adminRole);
//            }

            // Tworzenie użytkownika z rolą "Admin"
            User adminUser = new User();
            adminUser.setName("Grzesiu");
            adminUser.setPassword(passwordEncoder.encode("123456"));
            adminUser.setRoles("ROLE_ADMIN");
            userRepository.save(adminUser);
        }
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

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
