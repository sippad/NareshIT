package com.formbacking.dao;

import java.util.List;
import com.formbacking.bo.EmpBO;

public interface EmpDAO {
	public List<EmpBO> selectAllEmp();
	public int deleteEmp(int empNo);
}
