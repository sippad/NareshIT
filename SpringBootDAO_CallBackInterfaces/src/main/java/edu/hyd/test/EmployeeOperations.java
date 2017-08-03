package edu.hyd.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.config.AppConfig;
import edu.hyd.service.EmployeeService;
@SpringBootApplication
@ComponentScan(basePackages={"edu.hyd.dao","edu.hyd.service"})
@Import(value=AppConfig.class)
public class EmployeeOperations {
	public static void main(String[] args) throws Exception {
		ApplicationContext context =null;
		EmployeeService service=null;
		context = SpringApplication.run(EmployeeOperations.class, args);
		service = context.getBean("EmpServiceImpl",EmployeeService.class);
		System.out.println(service.retrieveAllEmpDetails());
		
	}
}
