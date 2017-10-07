package com.nt.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class StudentDTO implements Serializable{

	private static final long serialVersionUID = -5660488815415152385L;
	private String sname;
	private int age;
	private long mobile;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
