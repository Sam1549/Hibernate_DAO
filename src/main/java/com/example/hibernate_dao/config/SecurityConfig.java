package com.example.hibernate_dao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity()
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).authorizeHttpRequests(s ->
                s.requestMatchers(HttpMethod.GET, "/persons/by-city").hasRole("READ")
                        .requestMatchers(HttpMethod.GET, "/persons/by-age").hasRole("WRITE")
                        .requestMatchers(HttpMethod.GET, "/persons/by-name-surname").hasAnyRole("WRITE", "DELETE")
                        .requestMatchers(HttpMethod.GET, "/persons/by-name").permitAll()
                        .anyRequest().authenticated());
        return http.build();
//        http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).formLogin(Customizer.withDefaults());
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("Ivan")
                .password(encoder().encode("Password"))
                .roles("READ", "WRITE", "DELETE")
                .build();

        UserDetails user2 = User.builder()
                .username("Guest")
                .password(encoder().encode("Password2"))
                .roles("READ")
                .build();

        return new InMemoryUserDetailsManager(user, user2);
    }
}
