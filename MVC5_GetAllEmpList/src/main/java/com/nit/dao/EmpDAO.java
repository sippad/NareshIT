package com.nit.dao;

import java.util.List;

import com.nit.bo.EmpBO;

public interface EmpDAO {
	List<EmpBO> fetchEmpDetails();
}
