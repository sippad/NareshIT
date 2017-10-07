package com.nit.service;

import com.nit.dao.CouponDAO;
import com.nit.dao.CouponDAOImpl;
import com.nit.domain.CouponDetails;

public class CouponServiceImpl implements CouponService{

	private CouponDAO dao; 
	
	@Override
	public String saveCustomerService(CouponDetails coupon) {		
		dao = new CouponDAOImpl();
		String cpId=dao.saveCouponDetails(coupon);
		return cpId;
	}

}
