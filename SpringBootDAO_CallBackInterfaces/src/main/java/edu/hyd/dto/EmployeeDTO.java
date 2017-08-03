package edu.hyd.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	int sno;
	String sname;
	String job;
	long sal;
	
	public EmployeeDTO(){
		
	}
	
	public EmployeeDTO(int sno, String sname, String job, long sal) {	
		this.sno = sno;
		this.sname = sname;
		this.job = job;
		this.sal = sal;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public long getSal() {
		return sal;
	}
	public void setSal(long sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [sno=" + sno + ", sname=" + sname + ", job=" + job + ", sal=" + sal + "]";
	}
	
	
}
