package com.nit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="REGISTERATION_NO")
	private Long regno;
	@Column(name="TYPE")
	private String type;
	@Column(name="CHASIS_NO")
	private Long chasisNo;
	
	private static int count=0;
	
	public Vehicle(){
		count++;
		System.out.println("Vehicle Object created "+count);
	}
	
	public Vehicle(String type, Long chasisNo) {	
		this.type = type;
		this.chasisNo = chasisNo;
	}

	
	@Override
	public String toString() {
		return "Vehicle [regno=" + regno + ", type=" + type + ", chasisNo=" + chasisNo + "]";
	}

	public Vehicle(Long regno, String type, Long chasisNo) {
		this.regno = regno;
		this.type = type;
		this.chasisNo = chasisNo;		
	}
	
	/**
	 * @return the regno
	 */
	@Id
	@GenericGenerator(name="regNoGen",strategy="increment")
	@GeneratedValue(generator="regNoGen")
	public Long getRegno() {
		return regno;
	}
	/**
	 * @param regno the regno to set
	 */	
	public void setRegno(Long regno) {
		this.regno = regno;
	}
	/**
	 * @return the type
	 */
	@Column(name="TYPE",nullable=false,length=12)
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the chasisNo
	 */
	@Column(name="CHASIS_NO",nullable=false,length=12)
	public Long getChasisNo() {
		return chasisNo;
	}
	/**
	 * @param chasisNo the chasisNo to set
	 */
	public void setChasisNo(Long chasisNo) {
		this.chasisNo = chasisNo;
	}
	
	
}
