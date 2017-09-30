package com.nit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nit.command.StCommand;
import com.nit.dto.StudentDTO;
import com.nit.service.RegistrationService;

public class FormController extends SimpleFormController{
	private RegistrationService service;

	public void setService(RegistrationService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		StCommand cmd = (StCommand) command;
		StudentDTO dto = new StudentDTO();
		ModelAndView mav = new ModelAndView();
		String message = null;

		dto.setSno(cmd.getSno());
		dto.setSname(cmd.getSname());
		dto.setMobile(cmd.getSmob());
		dto.setEmail(cmd.getEmail());
		int status = service.register(dto);
		message = status == 1 ? "Successfull" : "FAILED";
		mav.setViewName(this.getSuccessView());
		mav.addObject("msg", message);
		return mav;
	}
}
