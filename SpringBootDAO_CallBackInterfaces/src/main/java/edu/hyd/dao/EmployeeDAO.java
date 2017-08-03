package edu.hyd.dao;

import java.util.List;

import edu.hyd.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public List<EmployeeBO> getAllEmpDetails() throws Exception; 
	
}
