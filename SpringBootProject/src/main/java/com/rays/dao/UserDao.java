package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDao {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	public RoleDao roleDao;

	public void populate(UserDTO dto) {

		RoleDTO roleDto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDto.getName());
	}

	public long add(UserDTO dto) {

		populate(dto);
		entityManager.persist(dto); // persist method to insert

		return dto.getId();
	}

	public void update(UserDTO dto) {

		populate(dto);
		entityManager.merge(dto); // merge method to insert or update
	}

	public void delete(UserDTO dto) {

		entityManager.remove(dto); // remove method to delete
	}

	public UserDTO findByPk(long id) {

		UserDTO dto = entityManager.find(UserDTO.class, id); // find method to find by id

		return dto;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = cq.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(root.get("firstName"), dto.getFirstName() + "%"));
			}

			if (dto.getRoleId() != null && dto.getRoleId() > 0) {
				predicateList.add(builder.equal(root.get("roleId"), dto.getRoleId()));
			}

			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				predicateList.add(builder.equal(root.get("dob"), dto.getDob()));
			}

		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<UserDTO> list = tq.getResultList();

		return list;
	}

	public UserDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = cq.from(UserDTO.class);

		Predicate condition = builder.equal(root.get(attribute), value);

		cq.where(condition);

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		List<UserDTO> list = tq.getResultList();

		UserDTO dto = null;

		if (list.size() == 1) {
			dto = list.get(0);
		}

		return dto;

	}
}
