package edu.hyd.test;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import edu.hyd.beans.TravelAgent;

public class ClientApp {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory=null;
		BeanDefinitionReader reader=null;
		TravelAgent ta;
		
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new FileSystemResource("src/edu/hyd/cfgs/applicationContext.xml"));
		ta = factory.getBean("travelAgent",TravelAgent.class);
	
	}
}
