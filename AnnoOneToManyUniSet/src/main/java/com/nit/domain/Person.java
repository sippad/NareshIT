package com.nit.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Person")
public class Person {
	@Id
	@GenericGenerator(name="pidGen",strategy="increment")
	@GeneratedValue(generator="pidGen")
	@Column(name="PERSON_ID")
	private Integer pid;
	@Column(name="PERSON_NAME")
	private String pname;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true,targetEntity=Vehicle.class)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JoinColumn(name="person_id",referencedColumnName="PERSON_ID")
	private Set<Vehicle> vehicles = new HashSet<>();
	
	
	private static int count=0;
	
	public Person() {
		count++;
		System.out.println("Person object created : "+count);
	}
	
	public Person(String pname, Set<Vehicle> vehicles) {	
		this.pname = pname;
		this.vehicles = vehicles;
	}



	public Person(Integer pid, String pname, Set<Vehicle> vehicles) {	
		this.pid = pid;
		this.pname = pname;
		this.vehicles = vehicles;
	}
	/**
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the vehicles
	 */
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
	
}
