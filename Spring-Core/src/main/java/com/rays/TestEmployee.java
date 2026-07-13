package com.rays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestEmployee {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("employee.xml"));

		Employee e = factory.getBean("emp", Employee.class); // alternative of typecaste
		
		System.out.println("Employee Name : " + e.getName());
		System.out.println("Emp Id : " + e.getEmpId());
		System.out.println("Employee Address : " + e.getAddress());
		
		System.out.println("------------------------------");
		
		Employee e2 = (Employee) factory.getBean("emp1");
		System.out.println("Employee Name : " + e2.getName());
		System.out.println("Emp Id : " + e2.getEmpId());
		System.out.println("Employee Address : " + e2.getAddress());
		
	System.out.println("------------------------------");
		
		Employee e3 = (Employee) factory.getBean("emp3");
		System.out.println("Employee Name : " + e3.getName());
		System.out.println("Emp Id : " + e3.getEmpId());
		System.out.println("Employee Address : " + e3.getAddress());
		
	}
}