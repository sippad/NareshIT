package com.orm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orm.dao.EmployeeDAO;
import com.orm.domain.Employee;
import com.orm.dto.EmployeeDTO;

@Service("empService")
@Transactional(transactionManager="hibernateTxMgr", propagation=Propagation.REQUIRED,readOnly=false)
public class EmployeeServiceImpl implements EmployeeService{

	@Resource
	private EmployeeDAO dao;
	
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> listDTO=  new ArrayList<>();
		List<Employee>  listHLO = dao.selectAllEmployee();
		for(Employee hlo :  listHLO) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(hlo, dto);
			listDTO.add(dto);
		}
		return listDTO;	
	}
	
}
