package com.formbacking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class JndiPersistenceConfig {

	@Bean
	public JndiObjectFactoryBean createJNDIFactory() {
		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("java:comp/env/ds1");
		return factory;
	}
}
