package edu.hyd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.beans.MyServletContainer;

public class ClientApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx;
		MyServletContainer container;
		
		ctx = new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");
		container = ctx.getBean("container",MyServletContainer.class);
		container.processRequest("First Request");
		container.processRequest("Second Request");
		System.out.println("Container Class : "+container.getClass());
		((ClassPathXmlApplicationContext) ctx).close();
		
		
	}

}
