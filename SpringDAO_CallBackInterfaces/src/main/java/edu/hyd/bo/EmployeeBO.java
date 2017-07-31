package edu.hyd.bo;

public class EmployeeBO {
		
	int no;
	String name;
	String Job;
	long sal;
	
	public EmployeeBO(){
		
	}
	
	public EmployeeBO(int no, String name, String job, long sal) {		
		this.no = no;
		this.name = name;
		Job = job;
		this.sal = sal;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(String job) {
		Job = job;
	}
	public void setSal(long sal) {
		this.sal = sal;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getJob() {
		return Job;
	}
	public long getSal() {
		return sal;
	}
}
