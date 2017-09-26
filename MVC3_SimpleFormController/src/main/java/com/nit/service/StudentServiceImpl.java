package com.nit.service;

import org.springframework.beans.BeanUtils;

import com.nit.bo.StudentBO;
import com.nit.dao.StudentDAO;
import com.nit.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO dao;

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}
	
@Override
	public int register(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto,bo);
		int result = dao.insert(bo);
		return result;
	}

}
