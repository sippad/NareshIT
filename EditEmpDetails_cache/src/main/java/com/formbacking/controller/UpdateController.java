package com.formbacking.controller;

import java.lang.Character.Subset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.formbacking.command.EmpCommand;
import com.formbacking.dto.EmpDTO;
import com.formbacking.service.EmpService;
import com.formbacking.utility.RequestURIUtil;

@SuppressWarnings("deprecation")
public class UpdateController extends SimpleFormController{
	private EmpService service;
	
	public void setService(EmpService service) {
		this.service = service;
	}
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors,
			Map controlModel) throws Exception {
		
		int empNo = Integer.parseInt(request.getParameter("id"));
		
		ModelAndView mav = new ModelAndView();		
		EmpCommand command = new EmpCommand();
		EmpDTO dto =service.getEmp(empNo);
		
		BeanUtils.copyProperties(dto,command);			
		mav.addObject("command",command);
		
		String baseURI =RequestURIUtil.getRequestURI(request.getRequestURI());
		mav.addObject("requestURI",baseURI);
				
		mav.setViewName("register");
		return mav;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		ModelAndView mav = new ModelAndView();
		RedirectView view = null;
		EmpDTO dto = new EmpDTO();		
		BeanUtils.copyProperties(command, dto);
		
		int eno = Integer.parseInt(request.getParameter("id"));
		dto.setEno(eno);
		int status =service.update(dto);		
		String updateStatus = status==0? "Update Failed" : dto.getEno()+" record updated" ;
		
		view = new RedirectView("list_emp.htm");
		view.setExposeModelAttributes(false);
		mav.setView(view);
		mav.addObject("updateStatus",updateStatus);
		return mav;
	}
}
