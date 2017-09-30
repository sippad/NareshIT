package com.nit.service;

import com.nit.dto.StudentDTO;

public interface RegistrationService {
	public int register(StudentDTO dto) throws Exception;
}
