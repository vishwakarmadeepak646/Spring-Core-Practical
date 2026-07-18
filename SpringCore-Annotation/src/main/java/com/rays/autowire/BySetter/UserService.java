package com.rays.autowire.BySetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bySetter")
public class UserService {
	
	@Autowired
	private UserDaoInterface userDao;

	
	
	public void add() {
		userDao.add();
	}

}
