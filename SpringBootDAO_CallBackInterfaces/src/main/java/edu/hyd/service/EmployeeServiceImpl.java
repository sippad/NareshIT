package edu.hyd.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hyd.bo.EmployeeBO;
import edu.hyd.dao.EmployeeDAO;
import edu.hyd.dto.EmployeeDTO;

@Service("EmpServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public List<EmployeeDTO> retrieveAllEmpDetails() throws Exception{
		List<EmployeeBO> listBO = dao.getAllEmpDetails();
		List<EmployeeDTO> listDTO = new ArrayList();
		for(EmployeeBO bo : listBO){
			EmployeeDTO dto = new EmployeeDTO(bo.getSno(),bo.getSname(),bo.getJob(),bo.getSal());
			listDTO.add(dto);
		}
		 return listDTO;
	}

}
