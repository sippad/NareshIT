package com.formbacking.dao;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.formbacking.bo.EmpBO;

public class SelectEmpReplacer implements MethodReplacer{

	private static final String GET_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("selectEmpReplacer");
			int empNo = (int)args[0];
			EmpBO empBO = jt.queryForObject(GET_EMP, new RowMapper<EmpBO>() {

				public EmpBO mapRow(ResultSet rs,int rowNum) throws SQLException
				{
					EmpBO bo = new EmpBO();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setDesg(rs.getString(3));
					bo.setSal(rs.getInt(4));
					return bo;
				}
			}, empNo);
			
			return empBO;				
	}

}
