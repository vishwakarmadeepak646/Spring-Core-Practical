package com.rays.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.AttendanceDao;
import com.rays.dto.AttendanceDTO;
import com.rays.dto.RoleDTO;



@Service
@Transactional
public class AttendanceService {
	
	@Autowired
	AttendanceDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(AttendanceDTO dto) {
		
		if(dto.getId() != null && dto.getId() > 0) {
			dao.update(dto);
		}else {
			dao.add(dto);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public AttendanceDTO findById(long id) {

		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public List<AttendanceDTO> search(AttendanceDTO  dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}
}