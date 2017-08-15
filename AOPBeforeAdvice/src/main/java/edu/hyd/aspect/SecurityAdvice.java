package edu.hyd.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import edu.hyd.helper.UserDetails;
import edu.hyd.service.AuthService;

public class SecurityAdvice implements MethodBeforeAdvice{
	
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	/* throws Throwable is used to throw any kind of exception from the method
	 * and also so We can also use exception chaining.
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {		
		boolean isAuth = authService.isAuthenticated();
		if(!isAuth)
			throw new IllegalArgumentException("Invalid user");
	}
}