package com.nit.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nit.bo.StudentBO;


public class RegisterationDAOImpl  implements RegistrationDAO {	
	private static final String INSERT_STUDENT="INSERT INTO STUDENT VALUES(?,?,?,?)";
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int insert(StudentBO bo) throws Exception {
		int status = jt.update(INSERT_STUDENT,bo.getSno(),bo.getSname(),bo.getMobile(),bo.getEmail());
		return status;
	}

}
