package com.orm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.orm.domain.Employee;

@Configuration
@ComponentScan(value="com.orm.dao")
public class PersistenceConfig {
	
	@Bean("dbcpDs")
	public DataSource createDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:sys");
		bds.setUsername("Asif123");
		bds.setPassword("Asif123");
		return bds;
	}
	
	@Bean("localSessionFactoryBean")
	public LocalSessionFactoryBean createLocalSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setAnnotatedClasses(Employee.class);
		lsfb.setDataSource(createDataSource());
		
		Properties hbProps = new Properties();
		hbProps.setProperty("hibernate.show_sql", "true");
		hbProps.setProperty("hibernate.format_sql", "true");
		hbProps.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		hbProps.setProperty("hibernate.autocommit","true");
		lsfb.setHibernateProperties(hbProps);		
		return lsfb;
	}
	
	
	@Bean("sessionFactory")
	public SessionFactory createSessionFactory() {
		return createLocalSessionFactory().getObject();
	}
	
	@Bean("ht")
	public HibernateTemplate createHibernateTemplate() {
		HibernateTemplate ht = new HibernateTemplate();
		ht.setSessionFactory(createSessionFactory());
		return ht;
	}
		
}
