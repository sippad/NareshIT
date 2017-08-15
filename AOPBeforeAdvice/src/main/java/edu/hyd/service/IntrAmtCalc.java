package edu.hyd.service;

public class IntrAmtCalc {
	public float calcIntr(float pAmt,float rate,float time){
		return (pAmt*rate*time)/100.0f;
	}
}
