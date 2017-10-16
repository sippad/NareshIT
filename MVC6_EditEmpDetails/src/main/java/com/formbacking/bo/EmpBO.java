package com.formbacking.bo;

public class EmpBO {
	private int eno;
	private String ename;
	private String desg;
	private int sal;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
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
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;		
	}
	@Override
	public String toString() {
		return "EmpBO [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", sal=" + sal + "]";
	} 
}
