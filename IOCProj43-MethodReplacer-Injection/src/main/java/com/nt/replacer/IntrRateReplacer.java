package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.support.MethodReplacer;

public class IntrRateReplacer implements MethodReplacer {
	private float rate;

	public void setRate(float rate) {
		this.rate = rate;
	}
	
	@Override
	public Object reimplement(Object bean, Method method, Object[] args) throws Throwable {
		float pAmt=0.0f,time=0.0f;
		System.out.println("\nClass IntrRateReplacer : reimplement(-,-,-)");
		System.out.println("\n   Method name :"+method.getName()+"\n  Class name : "+bean.getClass()+"\n  Args : "+Arrays.toString(args));
		pAmt=(float)args[0];
		time=(float)args[1];				
		//calc IntrAmount with discount rate of intrest
		StackTraceElement[] callingFrame = Thread.currentThread().getStackTrace();
		System.out.println();
		for(int i=0;i<callingFrame.length;i++) {
			Arrays.toString(callingFrame[i].getClass().getMethods());
			System.out.println("Stack Methods "+i+" : "+callingFrame[i].getMethodName()+"()");
		}
		 return  (pAmt*time*rate)/100.0f;
	}//reimplement(-,-,-)	
}//class


//ambiguous methods
//final class