package edu.hyd.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start,end;		
		Object retVal;
		System.out.println("In performance method");
		start = System.currentTimeMillis();
		retVal= invocation.proceed();
		end=System.currentTimeMillis();
		//System.out.println("Performance : "+(end-start));
		System.out.println("Exiting performance method");
		return invocation;
	}	
}
