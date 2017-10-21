package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MyEventSource;

public class EventTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/nt/common/application-context.xml");
		MyEventSource source = context.getBean("source",MyEventSource.class); 
		source.createEvent(" FIRE FIRE FIRE");
	}
}
