package edu.hyd.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.hyd.service.DBOperationService;

public class ClientTest {
	private static ApplicationContext ctx;
	private static DBOperationService service;
	public static void main(String[] args) throws Exception{
		int no,sal;
		String name,job;
		Scanner sc= new Scanner(System.in);		
		ctx= new ClassPathXmlApplicationContext("edu/hyd/cfgs/applicationContext.xml");
		service = ctx.getBean("Service",DBOperationService.class);				
		while(true){
			System.out.print("Enter Employee No : ");
			no=sc.nextInt();
			System.out.print("Enter Employee Name : ");
			name=sc.next();
			System.out.print("Enter Employee Job : ");
			job=sc.next();
			System.out.print("Enter Employee Salary : ");
			sal=sc.nextInt();
			System.out.println("Registering...");
			//System.out.println(service.registerEmp(no,name,job,sal));
			System.out.println(service.getAllEmpDetails());
			System.out.println("Specific employee details "+service.getEmpDetailsById(101));			
		}
	}
}