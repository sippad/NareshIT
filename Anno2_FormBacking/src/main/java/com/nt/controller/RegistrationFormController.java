package com.nt.controller;

import java.util.Map;
import javax.inject.Inject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentRegistrationService;

@Controller
public class RegistrationFormController {
	
	@Inject	
	private StudentRegistrationService registrationService;
	
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public String initiateFormValues(Model model) {
		StudentCommand command = new StudentCommand();
		command.setSname("enter your full name");
		command.setAge(0);
		command.setMobile(+91);
		model.addAttribute("command",command);		
		return "register";
	}
	
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String submitForm(Map<String,Object> map,@ModelAttribute("command") StudentCommand cmd){
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(cmd, dto);
		int status=registrationService.registerStudent(dto);
		String statusMsg = status==0? "Failed" : "Successfull";
		map.put("statusMsg",statusMsg);
		return "message";
	}
}
