package com.formbacking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.formbacking.bo.EmpBO;
import com.formbacking.dao.EmpDAO;
import com.formbacking.dto.EmpDTO;

public class EmpServiceImpl implements EmpService{

	private EmpDAO dao;
		
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmpDTO> getAllEmp() {
		List<EmpDTO> listDTO = new ArrayList<EmpDTO>();
		List<EmpBO> listBO = dao.selectAllEmp();
		System.out.println("service "+listBO);
		for(EmpBO bo : listBO) {
			EmpDTO dto = new EmpDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		}
		System.out.println("listDTO"+listDTO);
		return listDTO;
	}	
	
	public int removeEmp(int empNo) {
		return dao.deleteEmp(empNo);
	}
		
}