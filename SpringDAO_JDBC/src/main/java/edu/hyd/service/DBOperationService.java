package edu.hyd.service;

import java.util.List;
import java.util.Map;

import edu.hyd.dao.DBOperationsImpl;

public class DBOperationService {
	
	private DBOperationsImpl dao;
	
	public void setDao(DBOperationsImpl dao) {
		this.dao = dao;
	}
	
	public String registerEmp(int no, String name,String job,int sal){
		int result= dao.insert(no, name, job, sal);
		if(result==0)
			return no+" Emp is not registered";
		else
			return no+" Emp is Registered";
	}
	
	public List<Map<String,Object>> getAllEmpDetails() throws Exception{
		List<Map<String,Object>> list = dao.getAllEmpDetails(); 
		System.out.println(list.getClass().getName());
		if(list!=null)			
			return list;
		else 
			throw new Exception("Exception not found");
	}
	
	public Map<String,Object> getEmpDetailsById(int no) throws Exception {
		Map<String,Object> record =  dao.getSpecificEmpDetails(no);
		System.out.println(record.getClass().getName());
		if(record!=null)
			return record;			
		else
			throw new Exception("Record not found");				
	}
}
