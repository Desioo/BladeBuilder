package com.example.bladebuilder.conf;

import com.example.bladebuilder.model.entity.Role;
import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.model.reguest.CustomUserDetails;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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


@Controller
@EnableWebSecurity
public class SecurityConfig{

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

    @Bean
    public Filter customFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

                Role role = new Role();
                role.setName("ROLE_ADMIN");

                User user = new User();
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
        };
    }
}
