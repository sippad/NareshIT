package com.formbacking.dao;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.formbacking.bo.EmpBO;


public class SelectAllEmpReplacer implements MethodReplacer {

	private static final String GET_ALL_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public Object reimplement(Object bean, Method method, Object[] args) throws Throwable {
		System.out.println("selectAllEmpReplacer");
		List<EmpBO> list = new ArrayList<>();
		list = jt.queryForObject(GET_ALL_EMP, new EmpBORowMapper());
		System.out.println("dao :" + list);
		return list;		
	}

		
	private class EmpBORowMapper implements RowMapper<List<EmpBO>> {

		@Override
		public List<EmpBO> mapRow(ResultSet rs, int rowNum) throws SQLException {
			List<EmpBO> listBO = new ArrayList<EmpBO>();
			while (rs.next()) {
				EmpBO bo = new EmpBO();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSal(rs.getInt(4));
				listBO.add(bo);
			}
			return listBO;
		}

	}
}