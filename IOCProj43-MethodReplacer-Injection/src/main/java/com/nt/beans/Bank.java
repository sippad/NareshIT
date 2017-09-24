package com.nt.beans;

public  class Bank{
	
	public  float calcIntrAmt(float pAmt,float time){
		System.out.println("\nBank : calcIntrAmt(-,-) ");
		return  (pAmt*2.0f*time)/100.0f;
	}
	
	public float calcIntrAmt(float pAmt){
		System.out.println("\nBank : calcIntrAmt(-) ");
		return  (pAmt*12.0f*2.0f)/100.0f;		
	}
	
}	
