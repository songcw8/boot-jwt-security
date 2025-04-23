package org.example.bootjwtsecurity.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //csrf, cors 관련 여기서 설정 가능
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/api/**", "/swagger-ui/**","/v3/api-docs/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());
        return http.build();
    }
}
