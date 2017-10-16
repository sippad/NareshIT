package com.formbacking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import com.formbacking.service.EmpService;
import com.uri.util.RequestURIUtil;

public class DeleteEmpController extends AbstractController{

	private EmpService service;
	
	public void setService(EmpService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String delMsg=null;
		ModelAndView mav = new ModelAndView();
		RedirectView view = null; 
		
		int empNo = Integer.parseInt(req.getParameter("id"));		
		int delStatus = service.removeEmp(empNo);			
		delMsg=delStatus==0? "DELETION FAILED" : "DELETION SUCCESSFULL";
		mav.addObject("delStatus",delMsg);
		
		String requestURI=RequestURIUtil.getRequestURI(req.getRequestURI());
		mav.addObject("requestURI",requestURI);		
		
		view = new RedirectView("list_emp.htm");		
		view.setExposeModelAttributes(false);
		mav.setView(view);
				
		return mav;
	}
}