package edu.hyd.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.EmployeeService;

public class ClientTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = null;
		EmployeeService service=null;
		int sno;
		
		ctx = new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");
		service = ctx.getBean("service",EmployeeService.class);
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the employee id : ");
		//sno=sc.nextInt();
		System.out.println("Retrieving the record...");
		System.out.println(service.retrieveAllEmp());
		try{
			//System.out.println(service.retrieveEmp(sno));
			
		}catch(Exception e) { System.out.println("Record with id "+sno+" not Found");}
	}
}
