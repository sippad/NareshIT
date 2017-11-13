package com.formbacking.dao;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.formbacking.bo.EmpBO;
import com.formbacking.utility.EmpCache;


public class SelectAllEmpReplacer implements MethodReplacer {

	private static final String GET_ALL_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	
	private JdbcTemplate jt;
	private EmpCache cache;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public Object reimplement(Object bean, Method method, Object[] args) throws Throwable {		
		List<EmpBO> list = new ArrayList<>();
		cache= cache.getInstance();
		try {
		list = jt.query(GET_ALL_EMP, new EmpBORowMapper());
		System.out.println(cache);
		}catch(IncorrectResultSizeDataAccessException irse) {
			return null;
		}
		//System.out.println("dao :" + list);
		return list;		
	}

		
	private class EmpBORowMapper implements ResultSetExtractor<List<EmpBO>> {
		@Override
		public List<EmpBO> extractData(ResultSet rs) throws SQLException, DataAccessException {

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