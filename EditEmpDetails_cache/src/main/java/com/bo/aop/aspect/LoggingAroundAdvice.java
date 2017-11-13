package com.bo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.HttpRequest;

public class LoggingAroundAdvice{

	//private static Logger log = Logger.getLogger(LoggingAdvice.class);
	
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		//PropertyConfigurator.configure("log.properties"); 		 
		//log.debug(pjp.getClass()+" : "+pjp.getSignature());		
		System.out.println("-> "+pjp.getSignature());
		Object retVal = pjp.proceed();
		System.out.println("<- "+pjp.getSignature());
		//log.info("returned obj : "+retVal);
		return retVal;	
	}
 
		
	
	
}