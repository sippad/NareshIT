package com.formbacking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.formbacking.service.EmpService;

public class DeleteEmpController extends AbstractController{

	private EmpService service;
	
	public void setService(EmpService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String delMsg=null;
		int empNo = Integer.parseInt(req.getParameter("id"));
		int delStatus = service.removeEmp(empNo);
		delMsg=delStatus==0? "DELETION FAILED" : "DELETION SUCCESSFULL";
		System.out.println("deleteController");
		return new ModelAndView("forward:/list_emp.htm","delStatus",delMsg);
	}
}