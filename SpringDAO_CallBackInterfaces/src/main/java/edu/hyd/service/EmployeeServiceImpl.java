package edu.hyd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import edu.hyd.bo.EmployeeBO;
import edu.hyd.dao.EmployeeDAO;
import edu.hyd.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO dao;
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}
	
	//Copy BO object to Dto Object.
	
	public EmployeeDTO retrieveEmp(int no) throws Exception{
		EmployeeBO bo = dao.getEmployeeById(no);
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return	dto;
	}
	
	//Copy BOList to DTOList
	
	public List<EmployeeDTO> retrieveAllEmp() throws Exception{
		List <EmployeeBO> BOlist = dao.getAllEmployee();
		List<EmployeeDTO> DTOlist = new ArrayList();
		for (EmployeeBO bo: BOlist) {
			EmployeeDTO dto = new EmployeeDTO(bo.getNo(),bo.getName(),bo.getJob(),bo.getSal());
			DTOlist.add(dto);
		}
		return DTOlist;
	}
}
