package com.example.hibernate_dao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).authorizeHttpRequests(s ->
                s.requestMatchers(HttpMethod.GET, "/persons/by-city").hasRole("Admin")
                        .requestMatchers(HttpMethod.GET, "/persons/by-age").hasRole("Guest")
                        .requestMatchers(HttpMethod.GET, "/persons/by-name-surname").permitAll()
                        .anyRequest().authenticated());
        return http.build();
//        http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).formLogin(Customizer.withDefaults());
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("Sam")
                .password(encoder().encode("Password"))
                .roles("Admin", "Guest")
                .build();

        UserDetails user2 = User.builder()
                .username("Guest")
                .password(encoder().encode("Password2"))
                .roles("Guest")
                .build();

        return new InMemoryUserDetailsManager(user, user2);
    }
}
