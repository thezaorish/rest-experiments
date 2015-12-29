package com.zaorish.stm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"com.zaorish.stm.web"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    //

}
