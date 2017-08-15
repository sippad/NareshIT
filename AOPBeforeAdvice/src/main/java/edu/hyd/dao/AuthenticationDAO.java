package edu.hyd.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.hyd.helper.UserDetails;

public class AuthenticationDAO {
	private static final String CHECK_USER_AVAILABILITY="SELECT * FROM USERLIST WHERE USERNAME=? AND PASSWORD=?";
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	 	
	public boolean IsAvailable(UserDetails uDetails){
		try{
		Map<String,Object> m = jt.queryForMap(CHECK_USER_AVAILABILITY,uDetails.getUsername(),uDetails.getPassword());	
		if(m!=null)
			return true;			
		}catch(DataAccessException dae){
			System.out.println(" Username and password not found");
		}
		
		return false;
		
		
	}
}