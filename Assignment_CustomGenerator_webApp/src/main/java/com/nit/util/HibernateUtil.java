package com.nit.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;


public class HibernateUtil {

		private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
		private static SessionFactory factory;
		
	static {
		Configuration cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}	
		
		public static Session createSession() {
			Session ses=null;
			if(threadLocal.get()==null) {
				ses = factory.openSession();
				threadLocal.set(ses);
				return ses;
			}
			else {
				ses=threadLocal.get();
			}			
			
			
			return ses;
		}
		
		
		public static void closeSesssion() {
			Session ses=null;
			if(threadLocal.get()!=null) {
				ses = threadLocal.get();
				ses.close();
				threadLocal.remove();				
			}
		}
		
		public static void closeSessionFactory() {
			if(factory!=null) {
				factory.close();
			}
		}		
}
