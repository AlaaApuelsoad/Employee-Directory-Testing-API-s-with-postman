package com.qnetemployee.qnetdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class QnetEmployeeSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define a query to retrieve a user by username
        jdbcUserDetailsManager.
                setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        //define a query to retrieve the authorities by username
        jdbcUserDetailsManager.
                setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/system/list").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.GET,"/system/list/**").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/system/list").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/system/list").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/system/list/**").hasRole("ADMIN")

        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
