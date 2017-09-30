package com.kgl1688.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("password").roles("ADMIN").build());
        return manager;
    }

    @Configuration
    @Order(1)
    public class ApiWebSecurityConfigurerAdapter extends  WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")
                    .authorizeRequests()
                        .anyRequest()
                        .authenticated()
                        .and()
                    .httpBasic();
        }
    }

    @Configuration
    public class FormLoginWebSecurityConfigurerAdapter extends  WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //super.configure(http);
            http
                    .authorizeRequests()
                        .antMatchers("/secure/admin/**")
                        .hasRole("ADMIN")
                        .and()
                    .authorizeRequests()
                        .antMatchers("/secure/**")
                        .authenticated()
                        .and()
                    .formLogin()
                        .and()
                    .httpBasic();
        }
    }
}
