package edu.hyd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.IntrAmtCalculator;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrAmtCalculator iac=null;
		ctx=new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");		
		iac=ctx.getBean("factory",IntrAmtCalculator.class);
		System.out.println("In main method");
		iac.calcIntrAmt(10000.0f,1.5f,2);	
		System.out.println("Exiting main method");
	}
}
