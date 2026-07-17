package com.rays.autowire.bytype;

public class UserService {

	private UserDaoInterface userDao;

	public void setUserDao(UserDaoInterface userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}
}
