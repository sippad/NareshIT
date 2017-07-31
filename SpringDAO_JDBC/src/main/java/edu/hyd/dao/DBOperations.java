package edu.hyd.dao;

import java.util.List;
import java.util.Map;

public interface DBOperations {
	public int insert(int no,String name,String job,long sal);
	public List<Map<String,Object>> getAllEmpDetails() throws Exception;
	
}
