package com.formbacking.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.formbacking.dao")
public class OraclePersistenceConfig {
	
	
	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:sys");
		ds.setUsername("Asif123");
		ds.setPassword("Asif123");
		return ds;
	}
	
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		return new JdbcTemplate(createDataSource());
	}
		
}
