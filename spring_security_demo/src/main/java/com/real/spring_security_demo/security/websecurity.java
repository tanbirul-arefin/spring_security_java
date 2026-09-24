package com.real.spring_security_demo.security;

import com.real.spring_security_demo.service.coustomeruserdetailsservice;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class websecurity {

    private final coustomeruserdetailsservice Coustomeruserdetailsservice;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity

                // For full access during development mode
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headerConfigure -> headerConfigure.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))



                // To configure access control
// To configure access control
                .authorizeHttpRequests(httpRequestConfigurer -> httpRequestConfigurer

                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().fullyAuthenticated()
                )

                //user details configration
                .userDetailsService(Coustomeruserdetailsservice)


                // To configure form login behaviour
                .formLogin(formLoginConfigurer -> formLoginConfigurer

                        .loginPage("/login")
                )
                .build();
    }
}
