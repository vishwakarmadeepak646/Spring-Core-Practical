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

	public int update(UserDto dto) {

		String sql = "update st_user set firstName = ? , lastName = ?, login = ?, password = ? where id = ? ";

		jdbcTemplet.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(), dto.getId());

		return dto.getId();
	}

	public int delete(UserDto dto) {

		String sql = "delete from st_user where id = ? ";

		jdbcTemplet.update(sql, dto.getId());

		return dto.getId();
	}

}
