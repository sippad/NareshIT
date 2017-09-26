package com.nit.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.nit.bo.EmpBO;
import com.nit.dao.EmpDAO;
import com.nit.dto.EmpDTO;

public class EmpServiceImpl implements EmpService{
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;		
	}

	@Override
	public List<EmpDTO> getEmpDetails(){
		List<EmpDTO> listDTO=new ArrayList();
		List<EmpBO> listBO = dao.fetchEmpDetails();
		System.out.println("bo"+listBO);		
		if(listBO!=null)
		{
			for(EmpBO bo:listBO){
				EmpDTO dto = new EmpDTO();
				dto.setEno(bo.getEno());
				dto.setEname(bo.getEname());
				dto.setJob(bo.getJob());
				dto.setSal(bo.getSal());
				listDTO.add(dto);
			}
		}
		System.out.println("dto"+listDTO);
		return listDTO;
	}
}