package com.nt.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.model.CouponDetails;

public class CouponDetailsRowMapperReader implements RowMapper<CouponDetails> {

	@Override
	public CouponDetails mapRow(ResultSet rs, int rowNo) throws SQLException {
		CouponDetails cd = new CouponDetails();
		cd.setCouponNo(rs.getString("coupon_no"));
		cd.setCustName(rs.getString("cust_name"));
		cd.setBillAmt(rs.getFloat("bill_amt"));
		cd.setPurchaseDate(rs.getDate("purchase_date"));
		return cd;				
	}
	
}
