package com.nt.service;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentRegistrationDAO;
import com.nt.dto.StudentDTO;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService{
	
	@Inject
	private StudentRegistrationDAO registrationDao;
	
	public int registerStudent(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto,bo);
		return registrationDao.insertStudent(bo);
	}
}
