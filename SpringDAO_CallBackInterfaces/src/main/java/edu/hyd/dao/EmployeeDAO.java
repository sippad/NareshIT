package edu.hyd.dao;

import java.util.List;

import edu.hyd.bo.EmployeeBO;

public interface EmployeeDAO {
	public EmployeeBO getEmployeeById(int no) throws Exception;
	public List<EmployeeBO> getAllEmployee() throws Exception;	
}