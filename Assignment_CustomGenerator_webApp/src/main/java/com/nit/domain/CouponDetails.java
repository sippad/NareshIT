package com.nit.domain;

import java.util.Date;

public class CouponDetails {

	String coupon_no;
	String cust_name;
	float bill_amt;
	Date purchase_date;

	public void setCoupon_no(String coupon_no) {
		this.coupon_no = coupon_no;
	}

	public String getCoupon_no() {
		return coupon_no;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public float getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(float bill_amt) {
		this.bill_amt = bill_amt;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
}
