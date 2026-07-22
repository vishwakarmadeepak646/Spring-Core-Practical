package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.DTO.UserDTO;
import com.rays.service.UserService;

@Component("userTest")
public class TestUser {

	@Autowired
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("userTest", TestUser.class);

	//	test.add();
	//	test.update();
	//	test.delete();
	//	test.findByPk();
	}

	private void add() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Rahul");
		dto.setLastName("Raikwar");
		dto.setLogin("rahul@example.com");
		dto.setPassword("aa");
		
		service.save(dto); 
	}
	
	private void update() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Kajal");
		dto.setLastName("Raikwar");
		dto.setLogin("kajal@example.com");
		dto.setPassword("aaa");
		
		service.save(dto);
		
	}
	
	private void delete() {
		UserDTO dto = new UserDTO();
	
		service.delete(3);
		
	}
	
	private void findByPk() {
		UserDTO dto = service.findById(2);
		
		if (dto != null) {
			System.out.println("-----------------");
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("No Record found...");
		}
		
		
	}
}