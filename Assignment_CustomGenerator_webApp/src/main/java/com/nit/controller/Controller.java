package com.nit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.domain.CouponDetails;
import com.nit.service.CouponService;
import com.nit.service.CouponServiceImpl;
import com.nit.util.HibernateUtil;

public class Controller extends HttpServlet{

	private CouponService service;
	private static int count;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Request Received"+count++);
		RequestDispatcher rd = null;		
		CouponDetails coupon = new CouponDetails();
		service = new CouponServiceImpl();		
		
		String name = req.getParameter("name");
		int amount = Integer.parseInt(req.getParameter("amt"));		
		coupon.setCust_name(name);
		coupon.setBill_amt(amount);	
		
		String cpid = (String)service.saveCustomerService(coupon);						
		rd = req.getRequestDispatcher("/display_customerdetails.jsp");
		req.setAttribute("cpid",cpid);
		req.setAttribute("name",name);
		req.setAttribute("amount",amount);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
