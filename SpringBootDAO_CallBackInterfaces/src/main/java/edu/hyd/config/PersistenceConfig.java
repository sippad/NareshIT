package edu.hyd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="edu.hyd.dao")
public class PersistenceConfig {

}
