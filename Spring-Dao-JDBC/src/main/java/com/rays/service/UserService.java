package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDao;
import com.rays.dto.UserDto;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public int add(UserDto dto) {

		return dao.add(dto);
	}
	
	public int update(UserDto dto) {

		return dao.update(dto);
	}
	
	public int delete(UserDto dto) {

		return dao.delete(dto);
	}
}
