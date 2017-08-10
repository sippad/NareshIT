package edu.hyd.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Map<String,Object> cache = new HashMap<String, Object>();
		String key = invocation.getMethod().getName()+" "+invocation.getArguments();
		System.out.println("In CacheAdvice");
		Object retVal=null;
		if(!cache.containsKey(key)){
			retVal=invocation.proceed();
			cache.put(key,retVal);
			System.out.println("Exiting Cache Advice");			
			return retVal;
		}
		retVal=cache.get(key);
		System.out.println("Exiting Cache Advice");
		return retVal;	
	}
}
