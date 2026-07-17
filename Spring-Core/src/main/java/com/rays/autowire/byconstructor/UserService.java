package com.rays.autowire.byconstructor;

public class UserService {

	private UserDaoInterface userDao;

	public UserService(UserDaoInterface userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}
