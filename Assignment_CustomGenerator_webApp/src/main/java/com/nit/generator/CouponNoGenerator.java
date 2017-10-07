package com.nit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CouponNoGenerator implements IdentifierGenerator {
	private final String GET_CPID = "SELECT COUPONDETAILS_SEQ.NEXTVAL FROM DUAL";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		long seqNo = 0;
		try {
			Connection con = session.connection();
			PreparedStatement ps = con.prepareStatement(GET_CPID);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				rs.next();
				seqNo = rs.getInt(1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CPNO"+seqNo;
	}
}
