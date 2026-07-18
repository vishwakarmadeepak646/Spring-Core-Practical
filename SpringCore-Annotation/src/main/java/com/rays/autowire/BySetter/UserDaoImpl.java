package com.rays.autowire.BySetter;

import org.springframework.stereotype.Component;

@Component("byset")
public class UserDaoImpl implements UserDaoInterface  {

	public void add() {
		System.out.println("Inside Add method...");		
	}
	
	

}
