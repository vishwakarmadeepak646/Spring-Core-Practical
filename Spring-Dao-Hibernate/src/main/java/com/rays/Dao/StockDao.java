package com.rays.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.DTO.StockDTO;
import com.rays.DTO.UserDTO;

@Repository
public class StockDao {

	@Autowired
	SessionFactory sessionFactory;

	public int add(StockDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.save(dto);

		return dto.getId();
	}

	public void update(StockDTO dto) {
		Session session = sessionFactory.getCurrentSession();

		session.update(dto);
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();

		session.delete(findByPk(id));
	}

	public StockDTO findByPk(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(StockDTO.class, id);
	}
}
