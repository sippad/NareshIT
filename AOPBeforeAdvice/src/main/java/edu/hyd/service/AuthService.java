package edu.hyd.service;

import edu.hyd.dao.AuthenticationDAO;
import edu.hyd.exception.InvalidCredentialsException;
import edu.hyd.helper.UserDetails;

public class AuthService {

	private ThreadLocal<UserDetails> threadLocal = new ThreadLocal();
	UserDetails ud = new UserDetails();
	private AuthenticationDAO dao;

	public void setDao(AuthenticationDAO dao) {
		this.dao = dao;
	}

	public void signIn(String user, String pass) {
		ud.setUsername(user);
		ud.setPassword(pass);
		threadLocal.set(ud);
	}

	public void signOut() {
		threadLocal.remove();
	}

	public boolean isAuthenticated() throws InvalidCredentialsException{
		try{
		boolean flag = dao.IsAvailable(ud);		
		if (flag)
			return true;
		}catch(InvalidCredentialsException ic){
			throw new InvalidCredentialsException("Propogate",ic);
		}
		return false;
	}
}
