package com.rays.autowire.bytype;

import org.springframework.stereotype.Component;

@Component("byTypee")
public class UserDaoImpl implements UserDaoInterface  {

	public void add() {
		System.out.println("Inside Add method...");		
	}
	
	

}
