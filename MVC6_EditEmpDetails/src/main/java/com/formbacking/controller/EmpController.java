package com.formbacking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.formbacking.dto.EmpDTO;
import com.formbacking.service.EmpService;

public class EmpController extends AbstractController{
	
	private EmpService service;
	
	public void setService(EmpService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {		
		ModelAndView mav = new ModelAndView();				
		List<EmpDTO> listEmp = new ArrayList<>();
		listEmp = service.getAllEmp();
		System.out.println("controller"+listEmp);
		mav.setViewName("list_emp");
		mav.addObject("listEmp",listEmp);
		return mav;
	}
}
