package edu.hyd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.AuthService;
import edu.hyd.service.IntrAmtCalc;

public class ClientTest {
		public static void main(String[] args) {
		
		ApplicationContext context=null;
		AuthService service;
		IntrAmtCalc target=null;
		float result;
		context = new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");
		target = context.getBean("proxyFactory",IntrAmtCalc.class);
		service = context.getBean("authService",AuthService.class);
		service.signIn("Asif123","Asif123");
		result = target.calcIntr(50000.0f, 2.0f, 2.0f);
		System.out.println("Interest :"+result);
		service.signOut();
		((AbstractApplicationContext) context).close();
	}
}
