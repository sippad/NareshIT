package com.nt.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Bank;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Bank bank = null;

		float intrAmt = 0.0f;
		// create IOC container
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Bean
		bank = ctx.getBean("bank", Bank.class);
		System.out.print("Class name:: " + bank.getClass()); 
		System.out.print("\nSuper class : " + bank.getClass().getSuperclass());		
		System.out.println("\n Proxy class methods : ");
		
		int count = 1;
		for(Method method : bank.getClass().getMethods()) {			
			System.out.println("Method "+count+" : "+method);
			count++;
		}
		
		//invoke the mthod
		intrAmt = bank.calcIntrAmt(10000, 2);

		System.out.println("\nIntrest Amount::" + intrAmt);			
		System.out.println("\nFixed Term Intr Amount::" + bank.calcIntrAmt(10000));	
		// close container
		((AbstractApplicationContext) ctx).close();
	}// main
}// class
