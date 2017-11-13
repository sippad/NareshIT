package com.formbacking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.formbacking.bo.EmpBO;

@Repository
public class EmpDAOImpl_JavaV7 implements EmpDAO {

	private static final String GET_ALL_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String DELETE_EMP = "DELETE FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String INSERT_EMP = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String UPDATE_EMP = "UPDATE EMP SET ENAME=?,JOB=?,SAL=? WHERE EMPNO=?";

	@Autowired
	private JdbcTemplate jt;

	public List<EmpBO> selectAllEmp() {
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

	public int deleteEmp(int empNo) {
		return jt.update(DELETE_EMP, empNo);
	}

	public EmpBO selectEmp(int empNo) {

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
		System.out.println(empBO);
		return empBO;
	}

	public int insertEmp(EmpBO bo) {
		return jt.update(INSERT_EMP, bo.getEno(), bo.getEname(), bo.getDesg(), bo.getSal());
	}

	@Override
	public int UpdateEmp(EmpBO bo) {
		return jt.update(UPDATE_EMP, bo.getEname(), bo.getDesg(), bo.getSal(), bo.getEno());
	}

}