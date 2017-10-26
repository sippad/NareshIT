package com.orm.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dto.EmployeeDTO;
import com.orm.service.EmployeeService;

public class ORMTest {
	public static void main(String[] args) {
		EmployeeService service=null;
		ApplicationContext context = new ClassPathXmlApplicationContext("com/orm/config/application-context.xml");
		service=context.getBean("empServiceBean",EmployeeService.class);
		List<EmployeeDTO> listDTO= service.getAllEmployee();
		for(EmployeeDTO dto : listDTO)
			System.out.println(dto);
		((AbstractApplicationContext) context).close();
	}
}
