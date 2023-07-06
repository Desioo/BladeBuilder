package com.example.bladebuilder.conf;

import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.model.security.Role;
import com.example.bladebuilder.model.security.UserDetailsServiceImpl;
import com.example.bladebuilder.repository.RoleRepository;
import com.example.bladebuilder.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Value("${adminName}")
    private String adminName;

    @Value("${adminPassword}")
    private String adminPassword;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
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

    @PostConstruct
    public void init() {

        if (roleRepository.findRoleByName("ROLE_ADMIN") == null) {
            createAndSaveRoleAdmin();
        }

        Role adminRole = roleRepository.findRoleByName("ROLE_ADMIN");

        if (userRepository.count() == 0 || userRepository.findAllByRoles(adminRole).isEmpty()) {
            createAndSaveFirstAdmin(adminRole);
        }
    }

    private void createAndSaveFirstAdmin(Role adminRole) {

        User admin = new User();

        admin.setId(1);
        admin.setName(adminName);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRoles(List.of(adminRole));
        admin.setActive(true);

        userRepository.save(admin);
    }

    private void createAndSaveRoleAdmin() {
        roleRepository.save(new Role("ROLE_ADMIN"));
    }
}
