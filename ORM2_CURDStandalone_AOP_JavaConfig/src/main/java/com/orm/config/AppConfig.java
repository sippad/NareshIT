package com.orm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {PersistenceConfig.class,AopConfig.class,ServiceConfig.class})
public class AppConfig {
	
}
