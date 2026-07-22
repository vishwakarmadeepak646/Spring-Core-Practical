package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.DTO.StockDTO;
import com.rays.service.StockService;

@Component
public class TestStock {

	@Autowired
	StockService service;

	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		TestStock test = context.getBean("testStock", TestStock.class);

		// test.add();
		// test.update();
		// test.delete();
		test.findByPk();

	}

	private void findByPk() {
		StockDTO dto = service.findByPk(1);

		if (dto != null) {
			System.out.println("------------------");
			System.out.println(dto.getStockName());
			System.out.println(dto.getCode());
			System.out.println(dto.getQuantity());
			System.out.println(dto.getBuyDate());
			System.out.println(dto.getStatus());
		} else {
			System.out.println("No result found");
		}

	}

	private void delete() {
		StockDTO dto = new StockDTO();

		service.delete(3);

	}

	private void update() throws ParseException {
		StockDTO dto = new StockDTO();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

		dto.setId(3);
		dto.setCode("S002");
		dto.setStockName("CBI PSU Fund");
		dto.setQuantity(100);
		dto.setBuyDate(s.parse("2026-0-310"));
		dto.setStatus("Approved");

		service.update(dto);

	}

	private void add() throws ParseException {

		StockDTO dto = new StockDTO();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

		dto.setCode("S001");
		dto.setStockName("SBI PSU Fund");
		dto.setQuantity(10);
		dto.setBuyDate(s.parse("2026-01-10"));
		dto.setStatus("Approved");

		service.add(dto);

	}

}
