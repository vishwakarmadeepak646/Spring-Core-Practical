package com.rays.autowire.BySetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestBySetter {

	public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService s =  context.getBean("bySetter", UserService.class);
		
		s.add();
	}
}
