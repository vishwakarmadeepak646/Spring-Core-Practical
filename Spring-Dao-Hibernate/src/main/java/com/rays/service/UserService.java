package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.DTO.UserDTO;
import com.rays.Dao.UserDao;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserDTO dto) {

		if (dto.getId() > 0) { // add & Update both logic will be performed here
			dao.update(dto);
			System.out.println("Data updated successfully");
			return;
		}
		dao.add(dto);
		System.out.println("Data added successfully");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
		System.out.println("Data deleted successfully");
	}

	@Transactional(readOnly = true)
	public UserDTO findById(int i) {

		return dao.findByPK(i);
		

	}
}
