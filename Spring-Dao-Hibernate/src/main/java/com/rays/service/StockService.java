package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.DTO.StockDTO;
import com.rays.Dao.StockDao;

@Service
@Transactional
public class StockService {

	@Autowired
	StockDao dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int add(StockDTO dto) {

		int i = dao.add(dto);

		System.out.println("data added successfully" + i);
		return i;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(StockDTO dto) {
		dao.update(dto);
		System.out.println("data updated successfully");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
		System.out.println("data deleted successfully");
	}

	@Transactional(readOnly = true)
	public StockDTO findByPk(int id) {

		StockDTO dto = dao.findByPk(id);

		return dto;
	}
}
