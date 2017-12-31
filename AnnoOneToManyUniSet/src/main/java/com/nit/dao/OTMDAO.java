package com.nit.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nit.domain.Person;
import com.nit.domain.Vehicle;

public class OTMDAO {
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void saveDataUsingPerson() throws Exception{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vehicle v1 = new Vehicle("Bike",12523321L);
		
		Vehicle v2 = new Vehicle("Car",53423422L);
		
		Person p1 = new Person();
		p1.setPname("Daniel");		
		p1.getVehicles().add(v1);
		p1.getVehicles().add(v2);
		
		session.save(p1);
		transaction.commit();
		session.close();				
	}
	
	public void load() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Person");
		List<Person> list =query.list();		
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" ");
			//Lazy loading
			System.out.println(p.getVehicles().size());
		});
		session.close();
	}
}
