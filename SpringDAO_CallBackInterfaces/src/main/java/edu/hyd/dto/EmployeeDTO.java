package edu.hyd.dto;

public class EmployeeDTO {
	int no;
	String name;
	String job;
	long sal;
	public EmployeeDTO()
	{
		
	}

	public EmployeeDTO(int no, String name, String job, long sal) {
		this.no = no;
		this.name = name;
		this.job = job;
		this.sal = sal;
	}	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "EmployeeDTO [no=" + no + ", name=" + name + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
