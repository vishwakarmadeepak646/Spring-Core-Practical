package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifecycle {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

		Lifecycle c = (Lifecycle) context.getBean("cycle");  //bean created

		((ClassPathXmlApplicationContext) context).close();  //bean destroyed
	}
}
