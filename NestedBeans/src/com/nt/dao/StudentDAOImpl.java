package com.nt.dao;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl {
	private static final String INSERT_STUDENT_RESULT = "insert into student_res values(?,?,?,?);";
	private DataSource ds=null;
	private PreparedStatement ps=null;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public void storeStudentResult(StudentBO bo){
		Connection con
	}
	
}
