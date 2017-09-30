package com.nit.dao;

import com.nit.bo.StudentBO;

public interface RegistrationDAO {
	public int insert(StudentBO bo) throws Exception;
}
