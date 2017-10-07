package com.nit.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.domain.CouponDetails;
import com.nit.util.HibernateUtil;

public class CouponDAOImpl implements CouponDAO{

	private Session session;
	
	@Override
	public String saveCouponDetails(CouponDetails coupon) {		
		String cpId=null;
		session = HibernateUtil.createSession();
		Transaction tx = session.beginTransaction();
		try {
			cpId =(String) session.save(coupon);
		}catch (Exception e) {
			tx.rollback();
		}		
		tx.commit();
		HibernateUtil.closeSesssion();
		return cpId;
	}	
}
