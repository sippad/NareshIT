package com.nit.service;

import org.springframework.beans.BeanUtils;
import com.nit.bo.StudentBO;
import com.nit.dao.RegistrationDAO;
import com.nit.dto.StudentDTO;

public class RegistrationServiceImpl implements RegistrationService{
	private RegistrationDAO dao;

	public void setDao(RegistrationDAO dao) {
		this.dao = dao;
	}
	
	public int register(StudentDTO dto) throws Exception{		
		StudentBO bo = new StudentBO();	
		BeanUtils.copyProperties(dto,bo);
		int status =dao.insert(bo);
		return status;		
	}
	
}
