package edu.hyd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.hyd.bo.EmployeeBO;

@Repository("EmpDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static final String GETALLEMP = "SELECT NO,NAME,JOB,SALARY FROM SPRING_USERS";
	
	@Resource
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmpDetails() throws Exception {
		List<EmployeeBO> empbo = jt.query(GETALLEMP, new ResultSetExtractor<List<EmployeeBO>>(){
			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeBO> listBO = new ArrayList();
				while(rs.next()){
					EmployeeBO bo = new EmployeeBO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4));
					listBO.add(bo);
				}
				return listBO;
			}			
		});
		return empbo;
	}
}
