package edu.hyd.service;

import java.util.List;

import edu.hyd.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> retrieveAllEmpDetails() throws Exception;
}
