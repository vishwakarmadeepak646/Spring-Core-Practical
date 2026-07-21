package com.rays.dao;

import java.util.List;

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

	public void update(UserDto dto) {

		String sql = "update st_user set firstName = ? , lastName = ?, login = ?, password = ? where id = ? ";

		int i = jdbcTemplet.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.print("Data updated successfully " + i);
	}

	public void delete(UserDto dto) {

		String sql = "delete from st_user where id = ? ";

		int i = jdbcTemplet.update(sql, dto.getId());

		System.out.print("Data updated successfully " + i);
	}

	public UserDto findByLogin(String login) {

		String sql = "select * from st_user where login=?";

		Object[] param = { login };

		UserDto dto = jdbcTemplet.queryForObject(sql, param, new UserMapper());

		return dto;

	}

	public List<UserDto> search(UserDto dto, int pageNo, int pageSize) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1 ");

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}

			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append(" and login like '" + dto.getLogin() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
		}

		List<UserDto> list = jdbcTemplet.query(sql.toString(), new UserMapper());

		return list;

	}

}
