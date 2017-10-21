package com.formbacking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formbacking.command.EmpCommand;
import com.formbacking.dto.EmpDTO;
import com.formbacking.service.EmpService;
import com.uri.util.RequestURIUtil;

@Controller
public class UpdateController{
	@Autowired
	private EmpService service;
	
	@RequestMapping(value="edit.htm",method=RequestMethod.GET)
	protected String showForm(HttpServletRequest request,Map<String, Object> map) throws Exception {
		
		int empNo = Integer.parseInt(request.getParameter("id"));
					
		EmpCommand command = new EmpCommand();
		EmpDTO dto =service.getEmp(empNo);
		
		BeanUtils.copyProperties(dto,command);			
		map.put("command",command);
		
		String baseURI =RequestURIUtil.getRequestURI(request.getRequestURI());
		map.put("requestURI",baseURI);						
		return "register";
	}

	@RequestMapping(value="edit.htm",method=RequestMethod.POST)
	protected String onSubmit(HttpServletRequest request,@ModelAttribute("command") EmpCommand command,Map<String, Object> map) throws Exception {		
		EmpDTO dto = new EmpDTO();		
		BeanUtils.copyProperties(command, dto);
		
		int eno = Integer.parseInt(request.getParameter("id"));
		dto.setEno(eno);
		int status =service.update(dto);		
		String updateStatus = status==0? "Update Failed" : dto.getEno()+" record updated" ;
				
		map.put("updateStatus",updateStatus);
		return "redirect: list_emp.htm";
	}
}
