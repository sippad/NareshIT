package edu.hyd.service;

public class Calculate {
	
	public float calcIntrAmt(float amt,float rate,float time){
		System.out.println("    In target method :: IntrAmtCalculator");
		float result = (amt*rate*time)/100.0f;
		System.out.println("    Exiting target method :: IntrAmtCalculator");
		return result;
	}
	
	public float calcRectArea(float width, float height){
		System.out.println("    In target method :: Calculate Rectangle Area");
		float area = width* height;
		System.out.println("    Exiting target method :: Calculate Rectangle Area");
		return area;
		
	}
	
}
