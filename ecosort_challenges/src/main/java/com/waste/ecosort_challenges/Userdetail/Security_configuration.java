package com.waste.ecosort_challenges.Userdetail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security_configuration {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomeUserDetailservice();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
           return new BCryptPasswordEncoder();
    }
    
    
    public  DaoAuthenticationProvider daoAuthenticationProvider()
    {
      DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
      daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
      daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
      return daoAuthenticationProvider();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception
    {
         httpSecurity.csrf().disable().authorizeHttpRequests()
         .requestMatchers("/userRegistration","/registration")
         .permitAll()
         .anyRequest()
         .authenticated()
         .and()
         .formLogin();
         return httpSecurity.build();
    }
}
