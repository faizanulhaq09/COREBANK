//package com.corebank.user_service.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration // Marks this class as a Spring configuration class
//public class SecurityConfig {
//
//    @Bean // Defines a Spring Bean for the security filter chain
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for simpler API testing (be cautious in production)
//                .authorizeHttpRequests(authorize -> authorize
//                        // Require authentication for all /api/users/** endpoints
//                        .requestMatchers("/api/users/**").authenticated() // <-- THIS MUST BE .authenticated()
//                        // Permit Swagger UI access without authentication (good for documentation)
//                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                        .anyRequest().authenticated() // All other requests also require authentication
//                )
//                .httpBasic(); // <-- THIS MUST BE PRESENT TO ENABLE BASIC AUTH
//
//        return http.build();
//    }
//}