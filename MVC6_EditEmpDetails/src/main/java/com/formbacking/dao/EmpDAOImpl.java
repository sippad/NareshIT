package com.formbacking.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formbacking.bo.EmpBO;

public class EmpDAOImpl implements EmpDAO{
	
	private static final String GET_ALL_EMP="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String DELETE_EMP = "DELETE FROM EMP WHERE EMPNO=?";
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public List<EmpBO> selectAllEmp() {
		List<EmpBO> list = new ArrayList();
		list = jt.queryForObject(GET_ALL_EMP,
					(ResultSet rs ,int pos)->{
						List<EmpBO> listBO = new ArrayList<EmpBO>();						
						while(rs.next()) {
							EmpBO bo = new EmpBO();							
							bo.setEno(rs.getInt(1));
							bo.setEname(rs.getString(2));
							bo.setDesg(rs.getString(3));
							bo.setSal(rs.getInt(4));
							listBO.add(bo);
						}						
						return listBO;
					});
		System.out.println("dao :"+list);
		return list;
	}
	
	
	public int deleteEmp(int empNo) {
		return jt.update(DELETE_EMP,empNo);
	}
	
}
