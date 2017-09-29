package com.kgl1688.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan("com.kgl1688.mvc")
public class WebConfig extends WebMvcConfigurerAdapter{
}
