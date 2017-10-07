package com.nit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nit.util.HibernateUtil;

public class MyServlet implements ServletContextListener {
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Class.forName("com.nit.util.HibernateUtil");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
