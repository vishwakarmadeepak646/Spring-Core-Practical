package com.rays.test;

import java.util.Iterator;
import java.util.List;

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

	//	test.testAdd();
	//	test.testUpdate();
	//	test.testDelete();
	//	test.testFindByPk();
		test.search();
}

	private void search() {
		
		UserDto d = new UserDto();
		
	//	d.setFirstName("deepak");
		
		List<UserDto> list = service.search(d, 1, 2);
		
		Iterator<UserDto> it = list.iterator();
		
		while(it.hasNext()) {
			UserDto dto = it.next();
			
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}
		
	}

	private void testFindByPk() {
		
		UserDto dto = service.authenticate("deepak@gmail.com", "aa");
		
		if(dto !=null) {
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
		}else {
			System.out.println("No Record found...");
		}
		
	}

	private void testAdd() {

		UserDto dto = new UserDto();
		dto.setId(1);
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
		dto.setFirstName("Harsh");
		dto.setLastName("vishwakarma");
		dto.setLogin("deepak@gmail.com");
		dto.setPassword("aa");
		
		service.update(dto);

	
	}
	
	private void testDelete() {

		UserDto dto = new UserDto();
		dto.setId(2);
		
		service.delete(dto);

		
		
		// Doubt : From DB data is deleted but id is present
	}
}