package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Mobile;

public class SingletonTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/resources/application-context.xml");
		Mobile mob = null, mob1 = null,mob2 = null;
		
		mob=ctx.getBean("mobile",Mobile.class);
		System.out.println(mob.hashCode());
		
		mob1=ctx.getBean("mobile",Mobile.class);
		System.out.println(mob1.hashCode());
		mob2=ctx.getBean("mobile1",Mobile.class);
		System.out.println(mob2.hashCode());

	}
}
