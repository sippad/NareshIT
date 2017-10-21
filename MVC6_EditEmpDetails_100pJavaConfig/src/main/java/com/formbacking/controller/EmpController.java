package com.formbacking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formbacking.dto.EmpDTO;
import com.formbacking.service.EmpService;

@Controller
public class EmpController{
	
	@Autowired
	private EmpService service;
	
	@RequestMapping(value="list_emp.htm")
	public String handleRequestInternal(HttpServletRequest req, Map<String,Object> map) throws Exception {								
		List<EmpDTO> listEmp = new ArrayList<>();
		listEmp = service.getAllEmp();			
		map.put("listEmp",listEmp);
		return "list_emp";
	}
}
