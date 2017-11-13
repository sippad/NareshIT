package com.formbacking.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.formbacking.bo.EmpBO;

public class EmpCache implements Cloneable{

	private static boolean isInstantiated = false;
	private Map<Integer,EmpBO> map;	
	private static EmpCache instance;
	private boolean isStateChanged = true; 
	
	public boolean isStateChanged() {
		return isStateChanged;
	}

	public void setStateChanged(boolean isStateChanged) {
		this.isStateChanged = isStateChanged;
	}

	private EmpCache() throws InstantiationException {
		map = new ConcurrentHashMap<>();
	}	
	
	public static EmpCache getInstance() {
		try {
			if (instance == null) {
				synchronized (EmpCache.class) {
					if (instance == null) {
						instance = new EmpCache();
						isInstantiated = true;
						return instance;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("EmpCache Instance creation failed");
			e.printStackTrace();
		}
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		if(instance==null)
			try {
				throw new InstantiationException();
			} catch (InstantiationException e) {				
				e.printStackTrace();
			}
		return instance;
	}
	
	public List<EmpBO> getEmpList() {
		List<EmpBO> listBO = new ArrayList<>();
		if(map.isEmpty()) {			
			return null;			
		}		
		for (Map.Entry<Integer, EmpBO> entry : map.entrySet()){							
			 listBO.add(entry.getValue());			 
		}
		System.out.println("All employees retrieved from cache");
		return listBO;
	}

	public EmpBO getEmp(int id) {
		System.out.println("Employee retrieved from cache");
		return map.get(id);
	}
	
	public void remove(int id) {		
		map.remove(id);
		System.out.println("Employee eemoved from cache");
	}

	public void putEmp(int id, EmpBO empObj) {
		map.put(id, empObj);
		System.out.println("Employee is cached");
	}

	@Override
	public String toString() {
		List<EmpBO> listBO = new ArrayList();
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<Integer, EmpBO> entry : map.entrySet()){							
			sb.append("EmpNo : "+entry.getKey()+" Employee"+entry.getValue()+"\n");
		}		
		return sb.toString();
	}
	
	
}



