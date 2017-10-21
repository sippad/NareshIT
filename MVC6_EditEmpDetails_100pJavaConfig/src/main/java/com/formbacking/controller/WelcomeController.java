package com.formbacking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(value="welcome.htm")
	public String showForm() {
		return "welcome";
	}
	
}
