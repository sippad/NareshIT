package edu.hyd.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice{

	/* throws Throwable is used to throw any kind of exception from the method
	 * and also so We can also use exception chaining.
	 */
	@Override	
	public void before(Method method, Object[] args, Object target) throws Throwable{
		
	}	
}
