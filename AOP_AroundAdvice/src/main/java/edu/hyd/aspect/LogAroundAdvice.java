package edu.hyd.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable{
		System.out.println("In Log Around Method");
		Object args[] = invocation.getArguments();
		Object result=null;
		if((Float)args[0]<=0 || (Float)args[1]<=0 || (Float)args[2]<=0) {
				System.out.println("exiting LogAound Method");
				throw new IllegalArgumentException("Invalid amount or interest or time");
		}
		else{
			result = invocation.proceed();
			System.out.println("exiting LogAound Method");
			return result;
		}
		
	}

}
