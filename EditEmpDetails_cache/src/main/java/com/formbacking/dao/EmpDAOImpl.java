package com.formbacking.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.formbacking.bo.EmpBO;

public class EmpDAOImpl implements EmpDAO {

	private static final String GET_ALL_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String DELETE_EMP = "DELETE FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String INSERT_EMP = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String UPDATE_EMP = "UPDATE EMP SET ENAME=?,JOB=?,SAL=? WHERE EMPNO=?";
	private static final String GET_EMP_ID = "SELECT EMP_SEQ.NEXTVAL FROM DUAL";
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public List<EmpBO> selectAllEmp() {
		/*List<EmpBO> list = new ArrayList();
		list = jt.queryForObject(GET_ALL_EMP, (ResultSet rs, int pos) -> {
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
		});
		System.out.println("dao :" + list);*/
		return null;
	}

	public int deleteEmp(int empNo) {
		return jt.update(DELETE_EMP, empNo);
	}

	public EmpBO selectEmp(int empNo) {
	/*	EmpBO empBO = jt.queryForObject(GET_EMP, (ResultSet rs,int pos) -> {
			EmpBO bo = new EmpBO();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setDesg(rs.getString(3));
			bo.setSal(rs.getInt(4));
			return bo;
		},empNo);
		System.out.println(empBO);*/
		return null;
	}

	public int insertEmp(EmpBO bo) {
		int empNo = jt.queryForObject(GET_EMP_ID,Integer.class);	
		return jt.update(INSERT_EMP,empNo, bo.getEname(), bo.getDesg(), bo.getSal());
	}

	@Override
	public int UpdateEmp(EmpBO bo) {		
		return jt.update(UPDATE_EMP, bo.getEname(),bo.getDesg(),bo.getSal(),bo.getEno());
	}
	
	
}