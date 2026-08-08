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

import org.springframework.stereotype.Repository;

import com.rays.dto.AttendanceDTO;
import com.rays.dto.RoleDTO;

@Repository
public class AttendanceDao {

	@PersistenceContext
	EntityManager entityManager;

	public long add(AttendanceDTO dto) {

		entityManager.persist(dto);

		return dto.getId();
	}
	
	public void update(AttendanceDTO dto) {
		
		entityManager.merge(dto);
	}
	
	public void delete(long id) {
		
		AttendanceDTO dto = findByPk(id);
		
		entityManager.remove(dto);
	}
	
	public AttendanceDTO findByPk(long id) {
		
		AttendanceDTO dto =  entityManager.find(AttendanceDTO.class, id);
		
		return dto;
	}
	
	public List<AttendanceDTO> search(AttendanceDTO dto , int pageNo, int pageSize){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<AttendanceDTO> cq = builder.createQuery(AttendanceDTO.class);
		
		Root<AttendanceDTO> root = cq.from(AttendanceDTO.class);
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		if (dto != null) {

			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}

			if (dto.getStatus() != null && dto.getStatus().length() > 0) {
				predicateList.add(builder.like(root.get("status"), dto.getStatus() + "%"));
			}
		}
		
cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		
		TypedQuery<AttendanceDTO> query = entityManager.createQuery(cq);
		
		if(pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<AttendanceDTO> list = query.getResultList();
		
		return list;
	}

}
