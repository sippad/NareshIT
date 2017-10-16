package com.formbacking.service;

import java.util.List;

import com.formbacking.dto.EmpDTO;

public interface EmpService {
	public List<EmpDTO> getAllEmp();
	public int removeEmp(int empNo);
	public EmpDTO getEmp(int empNo);
	public int register(EmpDTO dto);
	public int update(EmpDTO dto);
}
