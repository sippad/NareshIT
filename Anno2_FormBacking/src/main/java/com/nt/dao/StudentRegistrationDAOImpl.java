package com.nt.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository
public class StudentRegistrationDAOImpl implements StudentRegistrationDAO{
	
	private static final String INSERT_STUDENT = "INSERT INTO REGISTER_STUDENT VALUES (?,?,?,?)";
	private static final String GET_SEQNO="SELECT STUSEQ.NEXTVAL FROM DUAL";
	@Inject
	private JdbcTemplate jt;
	
	public int getSno() {
		return jt.queryForObject(GET_SEQNO, Integer.class);
	}
	
	public int insertStudent(StudentBO bo) {
		return jt.update(INSERT_STUDENT,getSno(),bo.getSname(),bo.getAge(),bo.getMobile());
	}
	
}
