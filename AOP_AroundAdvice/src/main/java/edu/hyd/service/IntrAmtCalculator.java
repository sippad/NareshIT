package edu.hyd.service;

public class IntrAmtCalculator {
	
	public void calcIntrAmt(float amt,float rate,float time){
		System.out.println("  In target method :: IntrAmtCalculator");				
		float result = (amt*rate*time)/100.0f;
		System.out.println("  Interest amount :"+result);
		System.out.println("  Exiting target method :: IntrAmtCalculator");
	}
}
