package com.orm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="EMPLOYEE")
@Table(name="EMPLOYEE")
@NamedQuery(name="GET_EMP_BY_DESG", query = "FROM EMPLOYEE WHERE DESG IN (:desg1,:desg2)")
public class Employee {
	
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private int eno;
	private String ename;
	private String desg;
	private int salary;

	public int getEid() {
		return eno;
	}

	public void setEid(int eid) {
		this.eno = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public int getSal() {
		return salary;
	}

	public void setSal(int sal) {
		this.salary = sal;
	}

	@Override
	public String toString() {
		return "EmployeeHLO [eid=" + eno + ", ename=" + ename + ", desg=" + desg + ", sal=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desg == null) ? 0 : desg.hashCode());
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + eno;
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (desg == null) {
			if (other.desg != null)
				return false;
		} else if (!desg.equals(other.desg))
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (eno != other.eno)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

}
