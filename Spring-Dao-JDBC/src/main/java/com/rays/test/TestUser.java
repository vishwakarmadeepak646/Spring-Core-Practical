package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDto;
import com.rays.service.UserService;

@Component("TestUser")
public class TestUser {

	@Autowired
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("TestUser", TestUser.class);

		test.testAdd();
	//	test.testUpdate();
	//	test.testDelete();
}

	private void testAdd() {

		UserDto dto = new UserDto();
		dto.setId(2);
		dto.setFirstName("Deepak");
		dto.setLastName("vishwakarma");
		dto.setLogin("deepak@gmail.com");
		dto.setPassword("aa");
		
		int id = service.add(dto);

		System.out.println("data inserted successfully at id: " + id);
	}
	
	private void testUpdate() {

		UserDto dto = new UserDto();
		dto.setId(2);
		dto.setFirstName("Kapil");
		dto.setLastName("vishwakarma");
		dto.setLogin("deepak@gmail.com");
		dto.setPassword("aa");
		
		int id = service.update(dto);

		System.out.println("data updated successfully at id: " + id);
	}
	
	private void testDelete() {

		UserDto dto = new UserDto();
		dto.setId(2);
		
		int id = service.update(dto);

		System.out.println("data delted successfully at id: " + id);
		
		
		// Doubt : From DB data is deleted but id is present
	}
}