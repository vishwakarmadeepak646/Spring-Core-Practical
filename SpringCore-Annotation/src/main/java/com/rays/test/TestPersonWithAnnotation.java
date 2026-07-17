package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.AppConfig;

public class TestPersonWithAnnotation {

	public static void main(String[] args) {
		
		 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
	
		Person p = context.getBean("person", Person.class ); // Person.class is for type casting
		
		
		  p.setAddress("Indore"); 
		  p.setName("Abhi");
		 
		System.out.println("Name : " + p.getName());
		System.out.println("Address : " + p.getAddress());
		
	}

}
