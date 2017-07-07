
package edu.hyd.beans;

public class Bank {
	
	public float calcIntrAmount(float pAmt,float time){
		float IntrAmt = pAmt*time*2.0f/100;
		return IntrAmt;
	}
}
