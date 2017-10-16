package com.formbacking.controller;

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
import com.uri.util.RequestURIUtil;

@SuppressWarnings("deprecation")
public class InsertController extends SimpleFormController{
	
	private EmpService service;

	public void setService(EmpService service) {
		this.service = service;
	}
	
	@Override
	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors,
			Map controlModel) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		EmpCommand command = new EmpCommand();				
		mav.addObject("command",command);
				
		String requestURI = RequestURIUtil.getRequestURI(request.getRequestURI());
		mav.addObject("requestURI",requestURI);
			
		return mav;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {	
		ModelAndView mav = new ModelAndView();
		EmpDTO dto = new EmpDTO();
		RedirectView view = null;
		
		BeanUtils.copyProperties(command,dto);
		int insertStatus = service.register(dto);				
		
		view = new RedirectView("list_emp.htm");
		view.setExposeModelAttributes(false);
		mav.setView(view);
		
		return mav;
	}	
}
