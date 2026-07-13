package com.rays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {

	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Person.xml")); // path of xml class if it is in C drive then give c drive path C:user//beans//Person.xml
				
		Person p = (Person) factory.getBean("person");
		System.out.println("Name " + p.getName());
		System.out.println("Age " + p.getAge());
	}
}
