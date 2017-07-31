package edu.hyd.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperationsImpl implements DBOperations{
	
	private static final String INSERT = "INSERT INTO SPRING_USERS VALUES (?,?,?,?)";
	private static final String SELECT_ALL = "SELECT NO,NAME,JOB,SALARY FROM SPRING_USERS";
	private static final String GET_EMP_BY_ID = "SELECT * FROM SPRING_USERS WHERE NO=?";
	
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	//update(-,-,...) for insertion of data.
	public int insert(int no,String name,String job,long sal) {
		int result = jt.update(INSERT,no,name,job,sal);
		return result;
	}
	
	//queryForList("query") for multiple records 
	
	public List<Map<String,Object>> getAllEmpDetails(){
		List<Map<String,Object>> list = jt.queryForList(SELECT_ALL);
		return list;		
	}
	
	//queryForMap() for single record
	
	public Map<String,Object> getSpecificEmpDetails(int no){
		Map<String,Object>  record = jt.queryForMap(GET_EMP_BY_ID,no);
		return record;
	}
}
