package com.formbacking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formbacking.service.EmpService;
import com.uri.util.RequestURIUtil;

@Controller

public class DeleteEmpController{

	@Autowired			
	private EmpService service;	
	
	@RequestMapping(value="delete.htm")	
	protected String handleRequestInternal(HttpServletRequest req,Model model) throws Exception {
		String delMsg=null;				 
		
		int empNo = Integer.parseInt(req.getParameter("id"));		
		int delStatus = service.removeEmp(empNo);	
		delMsg=delStatus==0? "DELETION FAILED" : "DELETION SUCCESSFULL";
		model.addAttribute("delStatus",delMsg);
		
		String requestURI=RequestURIUtil.getRequestURI(req.getRequestURI());
		model.addAttribute("requestURI",requestURI);
		
		return "redirect:list_emp.htm";
	}
}