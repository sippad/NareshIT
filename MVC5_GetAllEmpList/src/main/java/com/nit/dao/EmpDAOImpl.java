package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nit.bo.EmpBO;

public class EmpDAOImpl implements EmpDAO {
	private JdbcTemplate jt;
	private final String GET_EMP_DETAILS = "SELECT EMPNO,ENAME,	JOB, SAL FROM EMP";

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public List<EmpBO> fetchEmpDetails(){
		List<EmpBO> listBO;
		listBO = jt.query(GET_EMP_DETAILS,new ResultExtractor1()); // query			
		return listBO;		
	}
	
	private	class ResultExtractor1 implements ResultSetExtractor<List<EmpBO>>{			
			@Override
			public List<EmpBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmpBO> listBO = new ArrayList<EmpBO>();
				while (rs.next()) {
					EmpBO bo = new EmpBO();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(Integer.parseInt(rs.getString(4)));
					listBO.add(bo);
				} // while
				return listBO;				
			}// extractData			
		}// inner class	
}
