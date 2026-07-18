package com.rays.autowire.byconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("byConstructor")
public class UserService {
	
	private UserDaoInterface userDao;

	@Autowired
	public UserService(UserDaoInterface userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}
