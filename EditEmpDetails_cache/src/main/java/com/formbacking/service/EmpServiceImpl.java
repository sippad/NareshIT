package com.formbacking.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.formbacking.bo.EmpBO;
import com.formbacking.dao.EmpDAO;
import com.formbacking.dto.EmpDTO;
import com.formbacking.utility.EmpCache;

public class EmpServiceImpl implements EmpService {

	private EmpDAO dao;
	private EmpCache cache;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	public EmpServiceImpl() {
		cache=cache.getInstance();
	}
	
	@Override
	public List<EmpDTO> getAllEmp() {
		List<EmpDTO> listDTO = new ArrayList<EmpDTO>();
		List<EmpBO> listBO = null;
		System.out.println(cache);
		if (cache.isStateChanged()) {			
			listBO = dao.selectAllEmp();
			cache.setStateChanged(false);
			System.out.println("got listBO  from dao");
		} else {
			listBO = cache.getEmpList();
			System.out.println("got listBO  from cache");
		}

		if (listBO != null) {
			addInCache(listBO);
			copyList(listBO, listDTO);
		}
		return listDTO;
	}

	public void addInCache(List<EmpBO> listBO) {
		if (listBO != null) {
			for (EmpBO bo : listBO) {
				cache.putEmp(bo.getEno(), bo);
			}
		}
	}

	public void copyList(List<EmpBO> listBO, List<EmpDTO> listDTO) {
		for (EmpBO bo : listBO) {
			EmpDTO dto = new EmpDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		}
	}

	public int removeEmp(int empNo) {
		int id = dao.deleteEmp(empNo);	
		cache.remove(id);
		cache.setStateChanged(true);
		return id;
	}

	public EmpDTO getEmp(int empNo) {
		EmpDTO dto = new EmpDTO();
		EmpBO bo = null;
		if (cache.getEmp(empNo) != null)
			bo = cache.getEmp(empNo);
		 else
			bo = dao.selectEmp(empNo);
		BeanUtils.copyProperties(bo, dto);	
		return dto;		
	}
	
	@Override
	public int register(EmpDTO dto) {
		EmpBO bo = new EmpBO();
		BeanUtils.copyProperties(dto, bo);
		int id = dao.insertEmp(bo);
		cache.setStateChanged(true);
		cache.putEmp(dto.getEno(),bo);
		return id;
	}

	@Override
	public int update(EmpDTO dto) {
		EmpBO bo = new EmpBO();
		BeanUtils.copyProperties(dto, bo);
		int id = dao.UpdateEmp(bo);
		cache.putEmp(dto.getEno(), bo);
		return id;
	}
}