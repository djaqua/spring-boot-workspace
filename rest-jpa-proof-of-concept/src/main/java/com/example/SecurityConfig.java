package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
    httpSec.csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authReq) -> authReq.anyRequest().authenticated())
        .sessionManagement((sessiongMgmt) -> sessiongMgmt.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    return httpSec.build();
  }
}
