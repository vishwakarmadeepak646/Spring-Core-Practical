package com.rays.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Person p = new Person();
@Component   // It will create bean 
public class Person {

	//  @Value("Ram") 	
	private String name;
	
//	@Value("Heaven") // This annotation will fixed assign the value to below attribute 
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
