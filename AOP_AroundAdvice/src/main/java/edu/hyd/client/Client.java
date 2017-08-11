package edu.hyd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.Calculate;
import edu.hyd.service.FindSquare;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Calculate iac=null;
		FindSquare sc=null;
		ctx=new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");		
		
		iac=ctx.getBean("factory1",Calculate.class);
		sc=ctx.getBean("factory2",FindSquare.class);
		
		System.out.println("In main method");
		
		float interest=iac.calcIntrAmt(10000.0f,1.5f,2.0f);
		float area = iac.calcRectArea(5.0f,5.0f);
		int Sqresult=sc.square(5);
		
		System.out.println("\n\nIntrresult : "+interest);
		System.out.println(" Rectangle area : "+area);
		System.out.println("SqResult :: "+Sqresult);
		
		
		System.out.println("Exiting main method");
		((AbstractApplicationContext) ctx).close();
	}
}
