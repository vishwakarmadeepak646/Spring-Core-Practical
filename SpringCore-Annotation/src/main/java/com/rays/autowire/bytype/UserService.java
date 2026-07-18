package com.rays.autowire.bytype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("byType")
public class UserService {
	
	@Autowired
	private UserDaoInterface userDao;
	
	public void add() {
		userDao.add();
	}

}
