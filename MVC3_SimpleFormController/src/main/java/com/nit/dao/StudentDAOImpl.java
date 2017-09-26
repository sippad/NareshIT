package com.nit.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.nit.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)"; 
	private JdbcTemplate template;	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(StudentBO bo) {		
		int count = template.update(INSERT_QUERY,bo.getSno(),bo.getSname(),bo.getSmob(),bo.getSadd());
		return count;
	}	
}
