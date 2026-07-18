package com.rays.autowire.byconstructor;

import org.springframework.stereotype.Component;

//@Component("bycons")  OR we can use below one as well
@Component
public class UserDaoImpl implements UserDaoInterface  {

	public void add() {
		System.out.println("Inside Add method...");		
	}
	
	

}
