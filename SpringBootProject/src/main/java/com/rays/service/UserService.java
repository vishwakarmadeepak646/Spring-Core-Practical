package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDao;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserDTO dto) {

		if (dto.getId() != null && dto.getId() > 0) {
			dao.update(dto);
			
		} else {
			dao.add(dto);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(long id) {
		return dao.findByPk(id);
	}
}
