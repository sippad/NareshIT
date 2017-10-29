package com.orm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.orm.domain.Employee;

@SuppressWarnings("unchecked")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String HQL_SELECT_ALL_EMPS = "FROM EMPLOYEE";
	private static final String HQL_SELECT_EMP_BY_DESG = "FROM EMPLOYEE WHERE DESG LIKE :DESG";
	private static final String HQL_DELETE_EMP_BY_ENO = "DELETE FROM EMPLOYEE WHERE ENO=:ENO";
	private static final String HQL_UPDATE_SAL_BY_ENO = "UPDATE EMP SET SALARY=? WHERE ENO=?";

	public HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	/* ALL INSERT OPERATIONS */

	@Override
	public int insertEmployee(Employee hlo) {
		return (int) ht.save(hlo);
	}
	
	/* ALL DELETE OPERATIONS */

	@Override
	public void deleteEmployee(Employee hlo) {
		ht.delete(hlo);
	}

	@Override
	public int deleteEmployeeByEno(int eno) {
		MyHibernateCallBack mhcb = new MyHibernateCallBack();
		mhcb.setEno(eno);
		return ht.execute(mhcb);
	}

	/* HIBERNATE CALLBACK INNER CLASS */

	private class MyHibernateCallBack implements HibernateCallback<Integer> {
		private int eno;

		public void setEno(int eno) {
			this.eno = eno;
		}

		@Override
		public Integer doInHibernate(Session session) throws HibernateException {
			Query query = session.createQuery(HQL_DELETE_EMP_BY_ENO).setParameter("eno", eno);
			return query.executeUpdate();
		}
	}

	/* ALL UPDATE OPERATIONS*/

	@Override
	public int updateEmployeeSal(int sal, int eno) {
		return ht.bulkUpdate(HQL_UPDATE_SAL_BY_ENO, sal, eno);
	}

	/* ALL SELECT OPERATIONS*/

	@Override
	public List<Employee> selectAllEmployee() {
		return (List<Employee>) ht.find(HQL_SELECT_ALL_EMPS);
	}

	@Override
	public List<Employee> selectEmployeeByDesg(String desg) {
		return (List<Employee>) ht.findByNamedParam(HQL_SELECT_EMP_BY_DESG, "desg", "%" + desg);
	}

	@Override
	public List<Employee> selectEmployeeByDesg(String desg1, String desg2) {
		return (List<Employee>) ht.findByNamedQueryAndNamedParam("GET_EMP_BY_DESG",
				new String[] { "desg1", "desg2" }, new String[] { "MANAGER", "CLERK" });
	}
	
}
