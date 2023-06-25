package com.example.bladebuilder.conf;

import com.example.bladebuilder.model.entity.Role;
import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.model.reguest.CustomUserDetails;
import com.example.bladebuilder.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private Environment environment;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/user", "/user/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll());

        http.addFilterBefore(customFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Autowired
    public Filter customFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

                String contentType = request.getContentType();

                if (contentType != null && contentType.startsWith("application/json")) {
                    // Odczytaj zawartość ciała żądania
                    String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

                    // Parsuj JSON do obiektu
                    JsonNode jsonNode = new ObjectMapper().readTree(requestBody);

                    // Odczytaj parametry z JSON-a
                    String adminName = jsonNode.get("adminName").asText();
                    String adminPassword = jsonNode.get("adminPassword").asText();

                    String configuredAdminName = environment.getProperty("admin.username");
                    String configuredAdminPassword = environment.getProperty("admin.password");

                    User user = new User();
                    Role role = new Role();

                    if (configuredAdminName.equals(adminName) && configuredAdminPassword.equals(adminPassword)) {
                        role.setName("ROLE_ADMIN");
                    } else {
                        role.setName("ROLE_USER");
                    }

                    user.setRoles(Set.of(role));

                    UserDetails userDetails = new CustomUserDetails(user);

                    // Tworzymy Authentication na podstawie UserDetails
                    Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());

                    // Ustawiamy kontekst bezpieczeństwa
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    // Kontynuujemy przetwarzanie żądania
                    filterChain.doFilter(request, response);

                    // Czyszczenie kontekstu bezpieczeństwa po przetworzeniu żądania
                    SecurityContextHolder.clearContext();
                }
            }

        };
    }
}
