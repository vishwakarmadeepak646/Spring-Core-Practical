package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonWithXML {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
				
		Person p1 = (Person) context.getBean("person");
		
		p1.setName("Radhe");
		p1.setAddress("Vrindavan");
				
		System.out.println("Name : " + p1.getName());
		System.out.println("Address : " + p1.getAddress());
	}
}
