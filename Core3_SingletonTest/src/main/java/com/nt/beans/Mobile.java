package com.nt.beans;

public class Mobile {
	String brandName;	
	String model;
	public String getBrandName() {
		return brandName;
}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Mobile [brandName=" + brandName + ", model=" + model + "]";
	}	
	
}
