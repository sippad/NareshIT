package com.nit.client;

import com.nit.dao.OTMDAO;

public class Test {
	public static void main(String[] args) {
		
		OTMDAO dao = new OTMDAO();
		try {
			/*dao.saveDataUsingPerson();*/
			dao.load();
		} catch (Exception e) {		
			e.printStackTrace();
		}finally {
			OTMDAO.sessionFactory.close();
		}
	}
}
