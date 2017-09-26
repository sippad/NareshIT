package com.nit.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.nit.dto.EmpDTO;
import com.nit.service.EmpService;

public class WelcomeController extends AbstractController{

	private EmpService service;
	 
	public void setService(EmpService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav= new ModelAndView();
		List<EmpDTO> listEmp = service.getEmpDetails();
		System.out.println(listEmp);
		mav.addObject("listEmp",listEmp);
		mav.setViewName("emp_details");		
		return mav;
	}
}
