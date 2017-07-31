package edu.hyd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import edu.hyd.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static final String GETEMP_BYID = "SELECT NO,NAME,JOB,SALARY FROM SPRING_USERS WHERE NO=?";
	private static final String GETALLEMP = "SELECT NO,NAME,JOB,SALARY FROM SPRING_USERS";	
	private JdbcTemplate jt;
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
public EmployeeBO getEmployeeById(int no) throws Exception{
		
		EmployeeBO empbo= jt.queryForObject(GETEMP_BYID,new RowMapper<EmployeeBO>(){
			
			//maprow() method will return a single record from database.
			
			@Override
			public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException{
				
				//Get database records values and add it to the BO object using setter methods				
				EmployeeBO bo= new EmployeeBO();
				bo.setNo(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getLong(4));
				return bo;
			}
		},no);
		return empbo;
	}

	@Override
	public List<EmployeeBO> getAllEmployee() throws Exception {
		List<EmployeeBO> list = jt.query(GETALLEMP, new ResultSetExtractor<List<EmployeeBO>>(){
			
			//extractData() is used to retrieve multiple records from the database
			
			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				//Copy database values to BO object using constructor and add BO object to the list.				
				
				List<EmployeeBO> list = new ArrayList();
				while(rs.next()){
				EmployeeBO bo = new EmployeeBO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4));
				list.add(bo);
				}
				return list;
			}
		
		});
		return list;
	}

}
