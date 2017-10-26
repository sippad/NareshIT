package com.orm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.orm.dao.EmployeeDAO;
import com.orm.domain.Employee;
import com.orm.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO dao;

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> listDTO=  new ArrayList<>();
		List<Employee>  listHLO = dao.selectAllEmployee();
		for(Employee hlo :  listHLO) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(hlo, dto);
			listDTO.add(dto);
		}
		return listDTO;
		
	}
	
	
}
