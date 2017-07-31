package edu.hyd.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperationsImpl implements DBOperations{
	
	private static final String INSERT = "INSERT INTO SPRING_USERS VALUES (?,?,?,?)";
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public int insert(int no,String name,String job,long sal) {
		int result = jt.update(INSERT,no,name,job,sal);
		return result;
	}
			
}
