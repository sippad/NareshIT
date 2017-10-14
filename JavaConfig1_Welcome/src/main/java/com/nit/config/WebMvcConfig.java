package com.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.nit.controller")
public class WebMvcConfig
{
  @Bean
  public ViewResolver configIVR() {	  
	  InternalResourceViewResolver ivr = new InternalResourceViewResolver();
	  ivr.setPrefix("/WEB-INF/pages/");
	  ivr.setSuffix(".jsp");
	  return ivr;
  }
}
