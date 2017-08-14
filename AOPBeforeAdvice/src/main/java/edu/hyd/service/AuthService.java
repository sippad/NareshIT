package edu.hyd.service;

import edu.hyd.helper.UserDetails;

public class AuthService {
	
	private ThreadLocal<UserDetails> threadLocal= new ThreadLocal();
	
	public void signIn(UserDetails details){
		threadLocal.set(details);		
	}
	
	public void signOut(){
		threadLocal.remove();
	}
	
	public boolean isAuthenticated(UserDetails ud){
		return true;
	}
}
