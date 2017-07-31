package edu.hyd.service;

import edu.hyd.dao.DBOperationsImpl;

public class DBOperationService {
	
	private DBOperationsImpl dao;

	public void setDao(DBOperationsImpl dao) {
		this.dao = dao;
	}
	
	public String registerEmp(int no, String name,String job,int sal){
		int result= dao.insert(no, name, job, sal);
		if(result==0)
			return no+"Emp is not registered";
		else
			return no+"Emp is Registered";
	}
	
}
