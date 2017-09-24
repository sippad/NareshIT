package com.nt.beans;

public class BankImpl extends Bank {
	public  float calcIntrAmt(float pAmt,float time){
		System.out.println("\nBankImpl : calcIntrAmt(-,-) ");
		return  (pAmt*2.0f*time)/100.0f;
	}
	
}
