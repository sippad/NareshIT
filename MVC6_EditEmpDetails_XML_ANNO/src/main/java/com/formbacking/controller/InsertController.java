package com.formbacking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formbacking.command.EmpCommand;
import com.formbacking.dto.EmpDTO;
import com.formbacking.service.EmpService;
import com.uri.util.RequestURIUtil;


@Controller
public class InsertController{
	
	@Autowired
	private EmpService service;
	
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	protected String showForm(Model model,HttpServletRequest request) throws Exception {				
		EmpCommand command = new EmpCommand();
		model.addAttribute("command",command);
		
		String requestURI = RequestURIUtil.getRequestURI(request.getRequestURI());
		model.addAttribute("requestURI",requestURI);
			
		return "register";
	}

	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	protected String onSubmit(HttpServletRequest request,Model model,@ModelAttribute("command")EmpCommand command) throws Exception {		
		EmpDTO dto = new EmpDTO();		
		
		BeanUtils.copyProperties(command,dto);
		int insertStatus = service.register(dto);
		model.addAttribute("insertStatus",insertStatus);
		
		return "redirect:list_emp.htm";
	}	
}
