package edu.hyd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.DBOperationService;

public class ClientTest {
	private static ApplicationContext ctx;
	private static DBOperationService service;
	public static void main(String[] args) {
		ctx= new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");		
		service = ctx.getBean("Service",DBOperationService.class);
		System.out.println(service.registerEmp(101,"Asif","Student",5000));
		
	}
}
