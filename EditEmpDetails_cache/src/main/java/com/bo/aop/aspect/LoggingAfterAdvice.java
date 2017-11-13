package com.bo.aop.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAfterAdvice {
	
	public void log(JoinPoint jp) throws Throwable{
		System.out.println("Exiting : "+jp.getSignature().getName());		
	}
}
