package com.bo.aop.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingBeforeAdvice {

	public void log(JoinPoint jp) throws Throwable{
		System.out.println("Entering : ->"+jp.getSignature().getName());
	}
}
