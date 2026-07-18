package com.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDto;

@Repository
public class UserDao {

	private JdbcTemplate jdbcTemplet;
	
	@Autowired
	public void setJdbcTemplet(DataSource ds) {
		
		this.jdbcTemplet = new JdbcTemplate(ds);
	}
	
	public int add(UserDto dto) {
		
		String sql = "insert into st_user values(?,?,?,?,?)";
		
		jdbcTemplet.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());
		
		return dto.getId();
		
	}
	
}
