package edu.hyd.service;

import java.util.List;

import edu.hyd.dto.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO retrieveEmp(int no) throws Exception;
	public List<EmployeeDTO> retrieveAllEmp() throws Exception;
}
