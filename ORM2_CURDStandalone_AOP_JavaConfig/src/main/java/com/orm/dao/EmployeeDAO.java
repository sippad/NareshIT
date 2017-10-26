package com.orm.dao;

import java.util.List;

import com.orm.domain.Employee;

public interface EmployeeDAO {
	
	public int insertEmployee(Employee hlo);
	
	public void deleteEmployee(Employee hlo);
	public int deleteEmployeeByEno(int eno);
		
	public int updateEmployeeSal(int sal, int eno);
		
	public List<Employee> selectAllEmployee();
	public List<Employee> selectEmployeeByDesg(String desg);
	
	public List<Employee> selectEmployeeByDesg(String desg1,String desg2);
		
}
