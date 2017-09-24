package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses= factory.openSession();
		Transaction tx = ses.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Asif");emp.setDesg("Student");emp.setSal(50000);
		ses.save(emp);
	//	ses.flush();		
	//	tx.commit();
		ses.close();
		factory.close();
	}
}
		