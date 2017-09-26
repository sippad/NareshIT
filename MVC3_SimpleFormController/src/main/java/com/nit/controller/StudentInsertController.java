package com.nit.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.nit.command.StudentCommand;
import com.nit.dto.StudentDTO;
import com.nit.service.StudentService;

@SuppressWarnings("deprecation")
public class StudentInsertController extends SimpleFormController {
	private StudentService service;
	private String message;		
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {		
		StudentCommand cmd = (StudentCommand) command;
		StudentDTO dto = new StudentDTO();
		
		dto.setSno(cmd.getSno());
		dto.setSname(cmd.getSname());
		dto.setSmob(cmd.getSmob());
		int result = service.register(dto);
		if(result>0)
			message="Successfull";
		else
			message="Failed";		
		System.out.println("Result : "+message);		
		return new ModelAndView(this.getSuccessView(),"message",message);
	}
}
